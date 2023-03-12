package com.tomholmes.products.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class UserEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "enabled")
    private boolean enabled;

    // `username` varchar(45) NOT NULL,
    @Column(name = "username")
    private String username;

    // `password` varchar(45) NOT NULL,
    @JsonIgnore
    @Column(name = "salted_password")
    private String password;

    // `prefix` varchar(45) DEFAULT NULL,
    @Column(name = "prefix")
    private String prefix;

    // `first_name` varchar(45) DEFAULT NULL,
    @Column(name = "first_name")
    private String firstName;

    // `middle_initial` varchar(45) DEFAULT NULL,
    @Column(name = "middle_initial")
    private String middleInitial;

    // `last_name` varchar(45) DEFAULT NULL,
    @Column(name = "last_name")
    private String lastName;

    // `suffix` varchar(45) DEFAULT NULL,
    @Column(name = "suffix")
    private String suffix;

    @Column(name = "entered_by")
    private long enteredBy;

    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

    @Column(name = "edited_by")
    private long editedBy;

    @Column(name = "edited_date")
    private LocalDateTime editedDate;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "reset_key")
    private String resetKey;

    @Column(name = "dob")
    private LocalDate dob;

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleInitial()
    {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial)
    {
        this.middleInitial = middleInitial;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
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

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getWorkPhone()
    {
        return workPhone;
    }

    public void setWorkPhone(String workPhone)
    {
        this.workPhone = workPhone;
    }

    public String getCellPhone()
    {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone)
    {
        this.cellPhone = cellPhone;
    }

    public String getResetKey()
    {
        return resetKey;
    }

    public void setResetKey(String resetKey)
    {
        this.resetKey = resetKey;
    }

    public LocalDate getDob()
    {
        return dob;
    }

    public void setDob(LocalDate dob)
    {
        this.dob = dob;
    }

    @Override
    public int hashCode()
    {
        return Objects
        .hash(cellPhone, dob, editedBy, editedDate, emailAddress, enabled, enteredBy, enteredDate, firstName, lastName, middleInitial, password, prefix, resetKey, suffix, userId, username, workPhone);
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
        UserEntity other = (UserEntity) obj;
        return Objects.equals(cellPhone, other.cellPhone) && Objects.equals(dob, other.dob) && editedBy == other.editedBy && Objects.equals(editedDate, other.editedDate)
            && Objects.equals(emailAddress, other.emailAddress) && enabled == other.enabled && enteredBy == other.enteredBy && Objects.equals(enteredDate, other.enteredDate)
            && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName) && Objects.equals(middleInitial, other.middleInitial) && Objects.equals(password, other.password)
            && Objects.equals(prefix, other.prefix) && Objects.equals(resetKey, other.resetKey) && Objects.equals(suffix, other.suffix) && userId == other.userId
            && Objects.equals(username, other.username) && Objects.equals(workPhone, other.workPhone);
    }

    @Override
    public String toString()
    {
        return "UserEntity [userId=" + userId + ", enabled=" + enabled + ", username=" + username + ", password=" + password + ", prefix=" + prefix + ", firstName=" + firstName + ", middleInitial="
            + middleInitial + ", lastName=" + lastName + ", suffix=" + suffix + ", enteredBy=" + enteredBy + ", enteredDate=" + enteredDate + ", editedBy=" + editedBy + ", editedDate=" + editedDate
            + ", emailAddress=" + emailAddress + ", workPhone=" + workPhone + ", cellPhone=" + cellPhone + ", resetKey=" + resetKey + ", dob=" + dob + "]";
    }

}