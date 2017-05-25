package fff.ccl.mettingmanger.pojo;

/**
 * @PS 会议室管理系统的用户类
 * @author caochunlin Email: chunlincao@foxmail.com
 * @Date 2017年5月22日下午8:58:16
 * @Version 1.8
 * @Since
 */

public class Employee {
	/**
	 * 员工Id
	 */
	private int employeeId;
	/**
	 * 员工真实姓名
	 */
	private String employeeName;
	/**
	 * 员工昵称
	 */
	private String userName;
	/**
	 * 员工密码
	 */
	private String userPassword;
	/**
	 * 员工手机号
	 */
	private long phone;
	/**
	 * 员工邮箱
	 */
	private String email;
	/**
	 * 员工所属部门
	 */
	private int deptid;
	/**
	 * 员工角色 1→表示管理员 2表示普通用户
	 */
	private int roleId;
	/**
	 * 用户的状态，分三种 0 ➡ 待审批，员工已注册但还未审批 1 ➡ 已审批，员工已注册并且已审批 3 ➡ 审批不通过 4 ➡
	 * 已关闭，员工已离职并不再使用 ️
	 */
	private int employeeStatus;
	/**
	 * 备注
	 */
	private String remark;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(int employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 员工的无参构造方法
	 */
	public Employee() {
	}

	/**
	 * 员工的全参构造方法
	 * 
	 * @param employeeId
	 * @param employeeName
	 * @param userName
	 * @param userPassword
	 * @param phone
	 * @param email
	 * @param deptid
	 * @param roleId
	 * @param employeeStatus
	 * @param remark
	 */
	public Employee(int employeeId, String employeeName, String userName, String userPassword, long phone, String email,
			int deptid, int roleId, int employeeStatus, String remark) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.userName = userName;
		this.userPassword = userPassword;
		this.phone = phone;
		this.email = email;
		this.deptid = deptid;
		this.roleId = roleId;
		this.employeeStatus = employeeStatus;
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptid;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + employeeStatus;
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + roleId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
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
		Employee other = (Employee) obj;
		if (deptid != other.deptid)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeStatus != other.employeeStatus)
			return false;
		if (phone != other.phone)
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (roleId != other.roleId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", phone=" + phone + ", email=" + email + ", deptid=" + deptid
				+ ", roleId=" + roleId + ", employeeStatus=" + employeeStatus + ", remark=" + remark + "]";
	}

}
