package com.tomholmes.products.library.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * CREATE TABLE `role` (
 * `role_id` int(11) NOT NULL AUTO_INCREMENT,
 * `role_code` varchar(5) NOT NULL,
 * `role_name` varchar(45) NOT NULL,
 * `entered_by` int(11) NOT NULL DEFAULT '1',
 * `entered_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
 * `edited_by` int(11) NOT NULL DEFAULT '1',
 * `edited_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 * PRIMARY KEY (`role_id`),
 * UNIQUE KEY `role_id_UNIQUE` (`role_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "role")
public class RoleEntity implements Serializable
{
    // `role_id` int(11) NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    // `role_code` varchar(5) NOT NULL,
    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_enabled")
    private boolean roleEnabled;

    // `role_name` varchar(45) NOT NULL,
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "entered_by")
    private long enteredBy;

    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

    @Column(name = "edited_by")
    private long editedBy;

    @Column(name = "edited_date")
    private LocalDateTime editedDate;

    public long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }

    public String getRoleCode()
    {
        return roleCode;
    }

    public void setRoleCode(String roleCode)
    {
        this.roleCode = roleCode;
    }

    public boolean isRoleEnabled()
    {
        return roleEnabled;
    }

    public void setRoleEnabled(boolean roleEnabled)
    {
        this.roleEnabled = roleEnabled;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public long getEnteredBy()
    {
        return enteredBy;
    }

    public void setEnteredBy(long enteredBy)
    {
        this.enteredBy = enteredBy;
    }

    public LocalDateTime getEnteredDate()
    {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate)
    {
        this.enteredDate = enteredDate;
    }

    public long getEditedBy()
    {
        return editedBy;
    }

    public void setEditedBy(long editedBy)
    {
        this.editedBy = editedBy;
    }

    public LocalDateTime getEditedDate()
    {
        return editedDate;
    }

    public void setEditedDate(LocalDateTime editedDate)
    {
        this.editedDate = editedDate;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(editedBy, editedDate, enteredBy, enteredDate, roleCode, roleEnabled, roleId, roleName);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RoleEntity other = (RoleEntity) obj;
        return editedBy == other.editedBy && Objects.equals(editedDate, other.editedDate) && enteredBy == other.enteredBy && Objects.equals(enteredDate, other.enteredDate)
            && Objects.equals(roleCode, other.roleCode) && roleEnabled == other.roleEnabled && roleId == other.roleId && Objects.equals(roleName, other.roleName);
    }

    @Override
    public String toString()
    {
        return "RoleEntity [roleId=" + roleId + ", roleCode=" + roleCode + ", roleEnabled=" + roleEnabled + ", roleName=" + roleName + ", enteredBy=" + enteredBy + ", enteredDate=" + enteredDate
            + ", editedBy=" + editedBy + ", editedDate=" + editedDate + "]";
    }

}
