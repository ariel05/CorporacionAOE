package com.corporacionaoe.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.corporacionaoe.app.models.entity.Member;

public interface IMemberDao extends PagingAndSortingRepository<Member, Long> {
	
	@Query("select count(m)>0 from Member m where m.profileId =?1")
	public boolean existByProfileId(Integer profileId);

	@Query("select count(m)>0 from Member m where m.steamId =?1")
	public boolean existBySteamId(Integer profileId);

	@Query("select m from Member m where m.profileId =?1")
	public Member findByProfileId(Integer profileId);
	
	@Query("select m from Member m where m.steamId =?1")
	public Member findBySteamId(Integer steamId);
}
