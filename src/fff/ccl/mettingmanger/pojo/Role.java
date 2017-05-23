/**
 * 
 */
package fff.ccl.mettingmanger.pojo;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2017年5月23日 下午1:21:28
 * @version 1.8
 * @since
 * @parameter
 * @PS
 */

public class Role {
	/**
	 * 角色ID 1代表管理员 2代表普通员工
	 */
	private int roleID;
	/**
	 * 角色名字 管理员 普通员工
	 */
	private String roleName;
	/**
	 * 备注
	 */
	private String remark;

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Role() {
		super();
	}

	public Role(int roleID, String roleName, String remark) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + roleID;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (roleID != other.roleID)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName + ", remark=" + remark + "]";
	}

}
