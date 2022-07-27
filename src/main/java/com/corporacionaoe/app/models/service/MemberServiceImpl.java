package com.corporacionaoe.app.models.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.transaction.Transactional;

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
				if(clanes != null) {
					miembros = clanes.get(Constantes.CLAN).get(Constantes.PLAYERS);
					for (Entry<String, String> entry : miembros.entrySet()) {
					    String key = entry.getKey();
					    Object value = entry.getValue();
					    autoUpdateDiverter(key, ( Map<String, String>)value);
					}
					System.out.println(miembros);
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	private void autoUpdateDiverter(String profileId, Map<String, String> player) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> laderboardType;
		Member member = null;
		if(memberDao.existByProfileId(Integer.valueOf(profileId))) {
			member = memberDao.findByProfileId(Integer.valueOf(profileId));
		}
		else {
			member = new Member();
		}
		member.setProfileId(Integer.valueOf(profileId));
		member.setName(player.get(Constantes.NAME_MAP_KEY));
		member.setCountry(CountryEnum.getCountry(player.get(Constantes.COUNTRY_MAP_KEY)));
		if(!player.get(Constantes.RATING_MAP_KEY).isEmpty()) {
			try {
				laderboardType = objectMapper.readValue(player.get(Constantes.RATING_MAP_KEY), Map.class);
				if(!laderboardType.get(Constantes.LADERBOARD_RM1V1_KEY).isEmpty()) {
					this.autoUpdateRm1v1(member, profileId);
				}
				if(!laderboardType.get(Constantes.LADERBOARD_RMTG_KEY).isEmpty()) {
					this.autoUpdateRmTg(member, profileId);
				}
				if(!laderboardType.get(Constantes.LADERBOARD_EW1V1_KEY).isEmpty()) {
					this.autoUpdateEw1v1(member, profileId);
				}
				if(!laderboardType.get(Constantes.LADERBOARD_EWTG_KEY).isEmpty()) {
					this.autoUpdateEwTg(member, profileId);
				}
				
				member.updateWinRated();
				
				memberDao.save(member);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		System.out.println(profileId + player);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void autoUpdateRm1v1(Member member, String profileId) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, String>> memberMap;
		Map<String, String> mld; //MemberLadderboard
		try {
			if(!memberRest.getForObject(Constantes.AOE_ENDPOINT_RM_1v1+profileId, String.class).isEmpty()) {
				memberMap = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_ENDPOINT_RM_1v1+profileId, String.class), Map.class);
				if(memberMap != null) {
					mld = memberMap.get(Constantes.LADERBOARD);
					if(!mld.get(Constantes.STEAM_ID).isEmpty())
					member.setSteamId(Integer.valueOf(mld.get(Constantes.STEAM_ID)));
					member.setRm1v1Rated(Integer.valueOf(mld.get(Constantes.RATING)));
					member.setRm1v1highestRated(Integer.valueOf(mld.get(Constantes.HIGHEST_RATING)));
					member.setRm1v1Streak(Integer.valueOf(mld.get(Constantes.STREAK)));
					member.setRm1v1TotalGames(Integer.valueOf(mld.get(Constantes.GAMES)));
					member.setRm1v1NumWin(Integer.valueOf(mld.get(Constantes.WINS)));
					member.setRm1v1NumLosses(Integer.valueOf(mld.get(Constantes.LOSSES)));
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void autoUpdateRmTg(Member member, String profileId) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, String>> memberMap;
		Map<String, String> mld; //MemberLadderboard
		try {
			if(!memberRest.getForObject(Constantes.AOE_ENDPOINT_RM_TG+profileId, String.class).isEmpty()) {
				memberMap = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_ENDPOINT_RM_1v1+profileId, String.class), Map.class);
				if(memberMap != null) {
					mld = memberMap.get(Constantes.LADERBOARD);
					if(!mld.get(Constantes.STEAM_ID).isEmpty())
					member.setSteamId(Integer.valueOf(mld.get(Constantes.STEAM_ID)));
					member.setRmTgRated(Integer.valueOf(mld.get(Constantes.RATING)));
					member.setRmTghighestRated(Integer.valueOf(mld.get(Constantes.HIGHEST_RATING)));
					member.setRmTgStreak(Integer.valueOf(mld.get(Constantes.STREAK)));
					member.setRmTgTotalGames(Integer.valueOf(mld.get(Constantes.GAMES)));
					member.setRmTgNumWin(Integer.valueOf(mld.get(Constantes.WINS)));
					member.setRmTgNumLosses(Integer.valueOf(mld.get(Constantes.LOSSES)));
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			e.printStackTrace();
		}
}

	@SuppressWarnings("unchecked")
	@Override
	public void autoUpdateEw1v1(Member member, String profileId) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, String>> memberMap;
		Map<String, String> mld; //MemberLadderboard
		try {
			if(!memberRest.getForObject(Constantes.AOE_ENDPOINT_EW_1v1+profileId, String.class).isEmpty()) {
				memberMap = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_ENDPOINT_RM_1v1+profileId, String.class), Map.class);
				if(memberMap != null) {
					mld = memberMap.get(Constantes.LADERBOARD);
					if(!mld.get(Constantes.STEAM_ID).isEmpty())
					member.setSteamId(Integer.valueOf(mld.get(Constantes.STEAM_ID)));
					member.setEw1v1Rated(Integer.valueOf(mld.get(Constantes.RATING)));
					member.setEw1v1highestRated(Integer.valueOf(mld.get(Constantes.HIGHEST_RATING)));
					member.setEw1v1Streak(Integer.valueOf(mld.get(Constantes.STREAK)));
					member.setEw1v1TotalGames(Integer.valueOf(mld.get(Constantes.GAMES)));
					member.setEw1v1NumWin(Integer.valueOf(mld.get(Constantes.WINS)));
					member.setEw1v1NumLosses(Integer.valueOf(mld.get(Constantes.LOSSES)));
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void autoUpdateEwTg(Member member, String profileId) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, String>> memberMap;
		Map<String, String> mld; //MemberLadderboard
		try {
			if(!memberRest.getForObject(Constantes.AOE_ENDPOINT_EW_TG+profileId, String.class).isEmpty()) {
				memberMap = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_ENDPOINT_RM_1v1+profileId, String.class), Map.class);
				if(memberMap != null) {
					mld = memberMap.get(Constantes.LADERBOARD);
					if(!mld.get(Constantes.STEAM_ID).isEmpty())
					member.setSteamId(Integer.valueOf(mld.get(Constantes.STEAM_ID)));
					member.setEwTgRated(Integer.valueOf(mld.get(Constantes.RATING)));
					member.setEwTghighestRated(Integer.valueOf(mld.get(Constantes.HIGHEST_RATING)));
					member.setEwTgStreak(Integer.valueOf(mld.get(Constantes.STREAK)));
					member.setEwTgTotalGames(Integer.valueOf(mld.get(Constantes.GAMES)));
					member.setEwTgNumWin(Integer.valueOf(mld.get(Constantes.WINS)));
					member.setEwTgNumLosses(Integer.valueOf(mld.get(Constantes.LOSSES)));
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			e.printStackTrace();
		}
	}
}
