package com.zjts.buscenter.common.model.req;


import com.zjts.buscenter.common.model.req.group.DeleteDriverInfo;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * 驾驶员的基本信息表 ,前台参数验证实体类
 * </p>
 *
 * @author han zq
 * @since 2018-10-24
 */
public class DriverInfoReq extends  BaseModel {


	/**
	 * 序号
	 */
	@NotNull(groups={DeleteDriverInfo.class})
	@ApiModelProperty(value = "员工id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
     * 员工号
     */
	@NotNull(message = "员工号不能为空")
	@ApiModelProperty(value = "员工号",example = "1001",required = true)
	private String employeeId;
    /**
     * 姓名
     */
	@NotEmpty(message = "员工姓名不能为空")
	@ApiModelProperty(value = "姓名",example = "张三")
	private String name;
    /**
     * 性别
     */
	@NotNull(message = "员工性别不能为空")
	@ApiModelProperty(value = "性别,0为男,1为女",example = "0")
	private Integer sex;
    /**
     * 年龄
     */
    @Max(value = 60)
	@NotNull(message = "员工年龄不能为空或者参数不符")
	@ApiModelProperty(value = "年龄",example = "28")
	private Integer age;
    /**
     * 身份证号
     */
    @NotEmpty(message = "身份证号不能为空")
    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}" +
			"((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",message = "身份证号错误")
	@ApiModelProperty(value = "身份证号",example = "131002199408204046")
	private String idcard;
    /**
     * 电话号
     */
	@NotEmpty(message = "手机号码不能为空")
	@Pattern(groups = {DeleteDriverInfo.class},regexp = "^1(3|4|5|7|8|9)\\d{9}$",message = "手机号码格式错误")
	@ApiModelProperty(value = "电话号",example = "13185471256")
	private String telephone;
    /**
     * 家庭住址
     */
	@NotEmpty(message = "家庭住址不能为空")
	@ApiModelProperty(value = "家庭住址",example = "河北省廊坊市广阳区万达广场")
	private String address;
	/**
	 * 所属公司
	 */
	@NotNull(message = "所属公司不能为空")
	@ApiModelProperty(value = "所属公司",example = "1")
	private Integer CompanyId;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注",example = "测试测试123")
	private String remark;
	/**
	 * 所属路线
	 */
	@ApiModelProperty(value = "所属路线",example = "24")
	private Integer inchargeLine;
	/**
	 * 评级分数
	 */
	@ApiModelProperty(value = "评级分数",example = "9")
	private Integer grade;
	/**
	 * 受到投诉次数
	 */
	@ApiModelProperty(value = "受到投诉次数",example = "2")
	private Integer complaintCount;
	/**
	 * 照片路径
	 */
	@NotEmpty(message = "照片路径不能为空")
	@ApiModelProperty(value = "照片路径",example = "201-10-18-wsdassda.jpg")
	private String photoPath;
	/**
	 * 驾驶证路径
	 */
	@NotEmpty(message = "照片路径不能为空")
	@ApiModelProperty(value = "驾驶证路径",example = "201-10-18-wsdassda.jpg")
	private String licensePath;
	/**
	 * 体检信息路径
	 */
	@NotEmpty(message = "体检信息不能为空")
	@ApiModelProperty(value = "体检信息路径",example = "201-10-18-wsdassda.jpg")
	private String healthPath;

	public String getLicensePath() {
		return licensePath;
	}

	public void setLicensePath(String licensePath) {
		this.licensePath = licensePath;
	}

	public String getHealthPath() {
		return healthPath;
	}

	public void setHealthPath(String healthPath) {
		this.healthPath = healthPath;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(Integer companyId) {
		CompanyId = companyId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getInchargeLine() {
		return inchargeLine;
	}

	public void setInchargeLine(Integer inchargeLine) {
		this.inchargeLine = inchargeLine;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getComplaintCount() {
		return complaintCount;
	}

	public void setComplaintCount(Integer complaintCount) {
		this.complaintCount = complaintCount;
	}





}
