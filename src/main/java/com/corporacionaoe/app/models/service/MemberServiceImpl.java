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
	public void save(Member cliente) {
		// TODO Auto-generated method stub
		
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
	@Transactional
	public void autoUpdate() {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, Map<String, String>>> clanes;
		Map<String, String> miembros;
		try {
			if(!memberRest.getForObject(Constantes.AOE_CLAN_API, String.class).isEmpty()) {
				clanes = objectMapper.readValue( memberRest.getForObject(Constantes.AOE_CLAN_API, String.class), Map.class);
				if(clanes != null) {
					miembros = clanes.get("CORP").get("players");
					for (Entry<String, String> entry : miembros.entrySet()) {
					    String key = entry.getKey();
					    Object value = entry.getValue();
					    autoUpdateDiverter(key, ( Map<String, String>)value);
					}
					System.out.println(miembros);
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void autoUpdateDiverter(String id, Map<String, String> player) {
		
		Member member = null;
		if(memberDao.existByProfileId(Integer.valueOf(id))) {
			member = memberDao.findByProfileId(Integer.valueOf(id));
		}
		else {
			member = new Member();
		}
		member.setProfileId(Integer.valueOf(id));
		member.setName(player.get("n"));
		member.setCountry(getCountry(player.get("c")));
		if(!player.get("r").isEmpty()) {
			
		}
		System.out.println(id + player);
	}
	
	private CountryEnum getCountry(String countryId) {
		List<CountryEnum> countryEnum = CountryEnum.getAllCountries();
		return countryEnum.stream().filter(p -> p.getId().equals(countryId)).findFirst().get();
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
					mld = memberMap.get("leaderboard");
					if(!mld.get("steam_id").isEmpty())
					member.setSteamId(Integer.valueOf(mld.get("steam_id")));
					member.setRm1v1Rated(Integer.valueOf(mld.get("rating")));
					member.setRm1v1highestRated(Integer.valueOf(mld.get("highest_rating")));
					member.setRm1v1Streak(Integer.valueOf(mld.get("streak")));
					member.setRm1v1TotalGames(Integer.valueOf(mld.get("games")));
					member.setRm1v1NumWin(Integer.valueOf(mld.get("wins")));
					member.setRm1v1NumLosses(Integer.valueOf(mld.get("losses")));
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			// TODO Auto-generated catch block
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
					mld = memberMap.get("leaderboard");
					if(!mld.get("steam_id").isEmpty())
					member.setSteamId(Integer.valueOf(mld.get("steam_id")));
					member.setRmTgRated(Integer.valueOf(mld.get("rating")));
					member.setRmTghighestRated(Integer.valueOf(mld.get("highest_rating")));
					member.setRmTgStreak(Integer.valueOf(mld.get("streak")));
					member.setRmTgTotalGames(Integer.valueOf(mld.get("games")));
					member.setRmTgNumWin(Integer.valueOf(mld.get("wins")));
					member.setRmTgNumLosses(Integer.valueOf(mld.get("losses")));
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			// TODO Auto-generated catch block
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
					mld = memberMap.get("leaderboard");
					if(!mld.get("steam_id").isEmpty())
					member.setSteamId(Integer.valueOf(mld.get("steam_id")));
					member.setEw1v1Rated(Integer.valueOf(mld.get("rating")));
					member.setEw1v1highestRated(Integer.valueOf(mld.get("highest_rating")));
					member.setEw1v1Streak(Integer.valueOf(mld.get("streak")));
					member.setEw1v1TotalGames(Integer.valueOf(mld.get("games")));
					member.setEw1v1NumWin(Integer.valueOf(mld.get("wins")));
					member.setEw1v1NumLosses(Integer.valueOf(mld.get("losses")));
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			// TODO Auto-generated catch block
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
					mld = memberMap.get("leaderboard");
					if(!mld.get("steam_id").isEmpty())
					member.setSteamId(Integer.valueOf(mld.get("steam_id")));
					member.setEwTgRated(Integer.valueOf(mld.get("rating")));
					member.setEwTghighestRated(Integer.valueOf(mld.get("highest_rating")));
					member.setEwTgStreak(Integer.valueOf(mld.get("streak")));
					member.setEwTgTotalGames(Integer.valueOf(mld.get("games")));
					member.setEwTgNumWin(Integer.valueOf(mld.get("wins")));
					member.setEwTgNumLosses(Integer.valueOf(mld.get("losses")));
				}
			}
		} catch (JsonProcessingException | RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
