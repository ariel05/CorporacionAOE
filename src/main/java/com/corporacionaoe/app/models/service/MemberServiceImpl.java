package com.corporacionaoe.app.models.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.corporacionaoe.app.models.dao.IMemberDao;
import com.corporacionaoe.app.models.entity.Member;
import com.corporacionaoe.app.utils.Constantes;
import com.corporacionaoe.app.utils.CountryEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RestTemplate memberRest;
	
	@Autowired
	private IMemberDao memberDao;
	
	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Member> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Member member) {
		memberDao.save(member);
		
	}

	@Override
	public Member findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Member> findByNombre(String term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member findOneByProfileIdOrSteamId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void autoUpdate() {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, Map<String, String>>> clanes;
		Map<String, String> miembros;
		try {
			if(!memberRest.getForObject(Constantes.AOE_CLAN_API, String.class).isEmpty()) {
				clanes = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_CLAN_API, String.class), Map.class);
				logger.info("Carga de miembros del clan -------> Iniciando");
				
				logger.info("Comenzando la consulta por Clan ------->  " + Constantes.AOE_CLAN_API);
				
				if(clanes != null) {
					miembros = clanes.get(Constantes.CLAN).get(Constantes.PLAYERS);
					for (Entry<String, String> entry : miembros.entrySet()) {
					    String key = entry.getKey();
					    Object value = entry.getValue();
					    autoUpdateDiverter(key, ( Map<String,Object>)value);
					}
					logger.info("Carga de miembros del clan -------> Finalizado con éxito!");
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	private void autoUpdateDiverter(String profileId, Map<String,Object> player) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> laderboardType = null;
		Map<String, Object> memberMap = null;
		Member member = null;
		if(memberDao.existByProfileId(Integer.valueOf(profileId))) {
			member = memberDao.findByProfileId(Integer.valueOf(profileId));
		}
		else {
			member = new Member();
		}
		member.setProfileId(Integer.valueOf(profileId));
		member.setName((String)player.get(Constantes.NAME_MAP_KEY));
		member.setCountry(CountryEnum.getCountry((String)player.get(Constantes.COUNTRY_MAP_KEY)));
		if(player.containsKey(Constantes.RATING_MAP_KEY)) {
			logger.info("Comenzando la consulta por Player ------->  " +(String)player.get(Constantes.NAME_MAP_KEY));
			laderboardType = (Map<String, String>)player.get(Constantes.RATING_MAP_KEY);
			try {
				if(laderboardType.containsKey(Constantes.LADERBOARD_RM1V1_KEY)) {
					memberMap = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_ENDPOINT_RM_1v1+profileId, String.class), Map.class);
					
					if(!((List<Object>)memberMap.get(Constantes.LADERBOARD)).isEmpty())
					this.autoUpdateRm1v1(member, (Map<String, Object>) ((List<Object>)memberMap.get(Constantes.LADERBOARD)).get(0) );
					
					memberMap = null;
				}
				if(laderboardType.containsKey(Constantes.LADERBOARD_RMTG_KEY)) {
					memberMap = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_ENDPOINT_RM_TG+profileId, String.class), Map.class);
					if(!((List<Object>)memberMap.get(Constantes.LADERBOARD)).isEmpty())
					this.autoUpdateRmTg(member,  (Map<String, Object>) ((List<Object>)memberMap.get(Constantes.LADERBOARD)).get(0) );
					
					memberMap = null;
				}
				if(laderboardType.containsKey(Constantes.LADERBOARD_EW1V1_KEY)) {
					memberMap = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_ENDPOINT_EW_1v1+profileId, String.class), Map.class);
					if(!((List<Object>)memberMap.get(Constantes.LADERBOARD)).isEmpty())
					this.autoUpdateEw1v1(member, (Map<String, Object>) ((List<Object>)memberMap.get(Constantes.LADERBOARD)).get(0) );
					
					memberMap = null;
				}
				if(laderboardType.containsKey(Constantes.LADERBOARD_EWTG_KEY)) {
					memberMap = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_ENDPOINT_EW_TG+profileId, String.class), Map.class);
					if(!((List<Object>)memberMap.get(Constantes.LADERBOARD)).isEmpty())
					this.autoUpdateEwTg(member,  (Map<String, Object>) ((List<Object>)memberMap.get(Constantes.LADERBOARD)).get(0) );
					
					memberMap = null;
				}
				member.updateWinRated();
				memberDao.save(member);
			} catch (JsonProcessingException | RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public void autoUpdateRm1v1(Member member, Map<String, Object> memberLadderboard) {
		if(memberLadderboard.get(Constantes.STEAM_ID) != null && !memberLadderboard.get(Constantes.STEAM_ID).toString().isEmpty())
		member.setSteamId(Long.valueOf(memberLadderboard.get(Constantes.STEAM_ID).toString()));
		member.setRm1v1Rated(Integer.valueOf(memberLadderboard.get(Constantes.RATING).toString()));
		member.setRm1v1highestRated(Integer.valueOf(memberLadderboard.get(Constantes.HIGHEST_RATING).toString()));
		member.setRm1v1Streak(Integer.valueOf(memberLadderboard.get(Constantes.STREAK).toString()));
		member.setRm1v1TotalGames(Integer.valueOf(memberLadderboard.get(Constantes.GAMES).toString()));
		member.setRm1v1NumWin(Integer.valueOf(memberLadderboard.get(Constantes.WINS).toString()));
		member.setRm1v1NumLosses(Integer.valueOf(memberLadderboard.get(Constantes.LOSSES).toString()));
	}

	@Override
	public void autoUpdateRmTg(Member member, Map<String, Object> memberLadderboard) {
		if(memberLadderboard.get(Constantes.STEAM_ID) != null && !memberLadderboard.get(Constantes.STEAM_ID).toString().isEmpty())
		member.setSteamId(Long.valueOf(memberLadderboard.get(Constantes.STEAM_ID).toString()));
		member.setRmTgRated(Integer.valueOf(memberLadderboard.get(Constantes.RATING).toString()));
		member.setRmTghighestRated(Integer.valueOf(memberLadderboard.get(Constantes.HIGHEST_RATING).toString()));
		member.setRmTgStreak(Integer.valueOf(memberLadderboard.get(Constantes.STREAK).toString()));
		member.setRmTgTotalGames(Integer.valueOf(memberLadderboard.get(Constantes.GAMES).toString()));
		member.setRmTgNumWin(Integer.valueOf(memberLadderboard.get(Constantes.WINS).toString()));
		member.setRmTgNumLosses(Integer.valueOf(memberLadderboard.get(Constantes.LOSSES).toString()));
	}

	@Override
	public void autoUpdateEw1v1(Member member, Map<String, Object> memberLadderboard) {
		if(memberLadderboard.get(Constantes.STEAM_ID) != null && !memberLadderboard.get(Constantes.STEAM_ID).toString().isEmpty())
		member.setSteamId(Long.valueOf(memberLadderboard.get(Constantes.STEAM_ID).toString()));
		member.setEw1v1Rated(Integer.valueOf(memberLadderboard.get(Constantes.RATING).toString()));
		member.setEw1v1highestRated(Integer.valueOf(memberLadderboard.get(Constantes.HIGHEST_RATING).toString()));
		member.setEw1v1Streak(Integer.valueOf(memberLadderboard.get(Constantes.STREAK).toString()));
		member.setEw1v1TotalGames(Integer.valueOf(memberLadderboard.get(Constantes.GAMES).toString()));
		member.setEw1v1NumWin(Integer.valueOf(memberLadderboard.get(Constantes.WINS).toString()));
		member.setEw1v1NumLosses(Integer.valueOf(memberLadderboard.get(Constantes.LOSSES).toString()));
	}

	@Override
	public void autoUpdateEwTg(Member member, Map<String, Object> memberLadderboard) {
		if(memberLadderboard.get(Constantes.STEAM_ID) != null && !memberLadderboard.get(Constantes.STEAM_ID).toString().isEmpty())
		member.setSteamId(Long.valueOf(memberLadderboard.get(Constantes.STEAM_ID).toString()));
		member.setEwTgRated(Integer.valueOf(memberLadderboard.get(Constantes.RATING).toString()));
		member.setEwTghighestRated(Integer.valueOf(memberLadderboard.get(Constantes.HIGHEST_RATING).toString()));
		member.setEwTgStreak(Integer.valueOf(memberLadderboard.get(Constantes.STREAK).toString()));
		member.setEwTgTotalGames(Integer.valueOf(memberLadderboard.get(Constantes.GAMES).toString()));
		member.setEwTgNumWin(Integer.valueOf(memberLadderboard.get(Constantes.WINS).toString()));
		member.setEwTgNumLosses(Integer.valueOf(memberLadderboard.get(Constantes.LOSSES).toString()));
	}
}
