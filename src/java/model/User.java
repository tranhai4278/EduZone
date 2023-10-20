package model;

import java.util.Date;

public class User {
    private int userId;
    private String password;
    private String fullName;
    private boolean gender;
    private String avatarUrl;
    private String phone;
    private String email;
    private int roleId;
    private boolean status;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;

    public User() {
    }

    public User(int userId, String fullName, int roleId) {
        this.userId = userId;
        this.fullName = fullName;
        this.roleId = roleId;
    }
    

    public User(int userId, String password, String fullName, boolean gender, String avatarUrl, String phone, String email, int roleId, boolean status, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.userId = userId;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.email = email;
        this.roleId = roleId;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public User(String password, String fullName, boolean gender, String phone, String email, int roleId, boolean status, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.roleId = roleId;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }
    
    public String roleName(int roleID) {
        switch (roleID) {
            case 4: return "Trainee";
            case 3: return "Trainer";
            case 2: return "Subject Manager";
            case 1: return "Admin";
        }
        return null;
    }
 
    public String getRoleName() {
        return roleName(getRoleId());
    }

    public String getStatusDisplay() {
        if (status) {
            return "Active";
        } else {
            return "Inactive";
        }
    }

    public String getGenderDisplay() {
        if (!status) {
            return "Male";
        }else {
            return "Female";
        }
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", password=" + password + ", fullName=" + fullName + ", gender=" + gender + ", avatarUrl=" + avatarUrl + ", phone=" + phone + ", email=" + email + ", roleId=" + roleId + ", status=" + status + ", createAt=" + createAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + '}';
    }

  
}
