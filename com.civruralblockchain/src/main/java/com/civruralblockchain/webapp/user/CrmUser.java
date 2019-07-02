package com.civruralblockchain.webapp.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.civruralblockchain.webapp.validation.FieldMatch;
import com.civruralblockchain.webapp.validation.ValidEmail;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmUser {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String userName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPassword;

	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;
        
        @NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String typeUser;


	public CrmUser() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}


	public String getEmail() {
		return email;
	}

        public String getTypeUser() {
            return typeUser;
        }

        public void setTypeUser(String typeUser) {
            this.typeUser = typeUser;
        }

            public void setEmail(String email) {
                    this.email = email;
            }

        
}
