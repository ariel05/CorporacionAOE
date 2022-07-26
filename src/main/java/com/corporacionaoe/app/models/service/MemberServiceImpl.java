package com.corporacionaoe.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.corporacionaoe.app.models.entity.Member;

public class MemberServiceImpl implements MemberService {

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

}
