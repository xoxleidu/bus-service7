package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 驾驶员的基本信息表
 * </p>
 *
 * @author han zq
 * @since 2018-10-24
 */
@TableName("driver_info")
public class DriverInfo extends Model<DriverInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 员工号
     */
	@TableField("employee_id")
	private Integer employeeId;
    /**
     * 姓名
     */
	private String name;
    /**
     * 性别
     */
	private Integer sex;
    /**
     * 年龄
     */
	private Integer age;
    /**
     * 身份证号
     */
	private String idcard;
    /**
     * 电话号
     */
	private String telephone;
    /**
     * 所属公司
     */
	@TableField("Company_id")
	private Integer CompanyId;
    /**
     * 家庭住址
     */
	private String address;
    /**
     * 照片路径
     */
	@TableField("photo_path")
	private String photoPath;
    /**
     * 备注
     */
	private String remark;
    /**
     * 所属路线
     */
	@TableField("incharge_line")
	private Integer inchargeLine;
    /**
     * 登记日期
     */
	@TableField("created_time")
	private Date createdTime;
    /**
     * 修改时间
     */
	@TableField("modified_time")
	private Date modifiedTime;
    /**
     * 评级分数
     */
	private Integer grade;
    /**
     * 受到投诉次数
     */
	@TableField("complaint_count")
	private Integer complaintCount;
	/**
	 * 驾驶员状态,1表示被禁用
	 */
	private Integer status;

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public DriverInfo setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public DriverInfo setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public String getName() {
		return name;
	}

	public DriverInfo setName(String name) {
		this.name = name;
		return this;
	}


	public Integer getAge() {
		return age;
	}

	public DriverInfo setAge(Integer age) {
		this.age = age;
		return this;
	}

	public String getIdcard() {
		return idcard;
	}

	public DriverInfo setIdcard(String idcard) {
		this.idcard = idcard;
		return this;
	}

	public String getTelephone() {
		return telephone;
	}

	public DriverInfo setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	public Integer getCompanyId() {
		return CompanyId;
	}

	public DriverInfo setCompanyId(Integer CompanyId) {
		this.CompanyId = CompanyId;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public DriverInfo setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public DriverInfo setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public DriverInfo setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getInchargeLine() {
		return inchargeLine;
	}

	public DriverInfo setInchargeLine(Integer inchargeLine) {
		this.inchargeLine = inchargeLine;
		return this;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public DriverInfo setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
		return this;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public DriverInfo setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
		return this;
	}

	public Integer getGrade() {
		return grade;
	}

	public DriverInfo setGrade(Integer grade) {
		this.grade = grade;
		return this;
	}

	public Integer getComplaintCount() {
		return complaintCount;
	}

	public DriverInfo setComplaintCount(Integer complaintCount) {
		this.complaintCount = complaintCount;
		return this;
	}

	@Override
	public String toString() {
		return "DriverInfo{" +
				"id=" + id +
				", employeeId='" + employeeId + '\'' +
				", name='" + name + '\'' +
				", sex=" + sex +
				", age=" + age +
				", idcard='" + idcard + '\'' +
				", telephone='" + telephone + '\'' +
				", CompanyId=" + CompanyId +
				", address='" + address + '\'' +
				", photoPath='" + photoPath + '\'' +
				", remark='" + remark + '\'' +
				", inchargeLine=" + inchargeLine +
				", createdTime=" + createdTime +
				", modifiedTime=" + modifiedTime +
				", grade=" + grade +
				", complaintCount=" + complaintCount +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
