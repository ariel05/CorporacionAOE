package com.corporacionaoe.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.corporacionaoe.app.models.entity.Member;

public interface IMemberDao extends CrudRepository<Member, Long> {

}
