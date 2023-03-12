package com.tomholmes.products.library.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user_role")
public class UserRoleEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @Column(name = "entered_by")
    private long enteredBy;

    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

    @Column(name = "edited_by")
    private long editedBy;

    @Column(name = "edited_date")
    private LocalDateTime editedDate;

    public long getUserRoleId()
    {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId)
    {
        this.userRoleId = userRoleId;
    }

    public UserEntity getUser()
    {
        return user;
    }

    public void setUser(UserEntity user)
    {
        this.user = user;
    }

    public RoleEntity getRole()
    {
        return role;
    }

    public void setRole(RoleEntity role)
    {
        this.role = role;
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
        return Objects.hash(editedBy, editedDate, enteredBy, enteredDate, role, user, userRoleId);
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
        UserRoleEntity other = (UserRoleEntity) obj;
        return editedBy == other.editedBy && Objects.equals(editedDate, other.editedDate) && enteredBy == other.enteredBy && Objects.equals(enteredDate, other.enteredDate)
            && Objects.equals(role, other.role) && Objects.equals(user, other.user) && userRoleId == other.userRoleId;
    }

    @Override
    public String toString()
    {
        return "UserRoleEntity [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + ", enteredBy=" + enteredBy + ", enteredDate=" + enteredDate + ", editedBy=" + editedBy
            + ", editedDate=" + editedDate + "]";
    }

}
