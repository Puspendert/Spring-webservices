package com.learn.persistence.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_privilege")
public class RolePrivilege implements Serializable {
	@Id
	@Column(name = "ROLE_ID")
	private Long roleId;
	@Id
	@Column(name = "PRIV_ID")
	private Long privId;

	public RolePrivilege() {

	}

	public RolePrivilege(Long roleId, Long privId) {
		this.roleId = roleId;
		this.privId = privId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPrivId() {
		return privId;
	}

	public void setPrivId(Long privId) {
		this.privId = privId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId, privId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		RolePrivilege that = (RolePrivilege) obj;

		return (Objects.equals(privId, that.privId) && Objects.equals(roleId, that.roleId));
	}

}
