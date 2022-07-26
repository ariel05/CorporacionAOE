package com.corporacionaoe.app.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AuthorityEnum {

	ROLE_USER ("ROLE_USER", "Usuario"),
	ROLE_ADMIN("ROLE_ADMIN", "Administrador"),
	ROLE_MEMBER("ROLE_MEMBER", "Miembro"),
	ROLE_SUPERADMIN("ROLE_SUPERADMIN", "Super administrador");

	private String id;
	private String descripcion;

	AuthorityEnum(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
    public static AuthorityEnum[] getAssignableRoles() {
    	
    	List<AuthorityEnum> assignableRoles = Arrays.stream(AuthorityEnum.values()).collect(Collectors.toList());
    	
    	return (AuthorityEnum[]) assignableRoles.toArray(new AuthorityEnum[assignableRoles.size()]);
    }
}
