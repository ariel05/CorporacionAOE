package com.corporacionaoe.app.models.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.corporacionaoe.app.models.entity.Member;

public interface MemberService {
	
	public List<Member> findAll();

	public Page<Member> findAll(Pageable pageable);
	
	public void save(Member cliente);
	
	public Member findOne(Long id);

	public Member findOneByProfileIdOrSteamId(Long id);
	
	public void delete(Long id);
	
	public List<Member> findByNombre(String term);
	
	public void autoUpdate();
	
	public void autoUpdateRm1v1(Member member,  Map<String, Object> memberMap);

	public void autoUpdateRmTg(Member member,  Map<String, Object> memberMap);
	
	public void autoUpdateEw1v1(Member member,  Map<String, Object> memberMap);

	public void autoUpdateEwTg(Member member,  Map<String, Object> memberMap);

}
