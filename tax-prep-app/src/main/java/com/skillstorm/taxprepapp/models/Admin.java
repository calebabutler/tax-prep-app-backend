package com.skillstorm.taxprepapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADMINS")
public class Admin {

    @Id
    @Column(name = "oauth_id")
    private String oauthId;

    public Admin() {
    }

    public Admin(String oauthId) {
        this.oauthId = oauthId;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oauthId == null) ? 0 : oauthId.hashCode());
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
        Admin other = (Admin) obj;
        if (oauthId == null) {
            if (other.oauthId != null)
                return false;
        } else if (!oauthId.equals(other.oauthId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Admin [oauthId=" + oauthId + "]";
    }

}
