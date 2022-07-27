package com.corporacionaoe.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.corporacionaoe.app.models.entity.Member;

public interface IMemberDao extends CrudRepository<Member, Long> {

	public boolean existByProfileId(Integer profileId);

	public boolean existBySteamId(Integer profileId);

	public Member findByProfileId(Integer profileId);
	
	public Member findBySteamId(Integer steamId);
}
