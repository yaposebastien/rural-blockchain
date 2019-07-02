package com.civruralblockchain.webapp.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;
        
        @Column(name = "typeUser")
	private String typeUser;

        //Adding Annotation for Many to Many relationship with Table Roles
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;
        
       

	public User() {
	}

	public User(String userName, String password, String email, String typeUser) {
		this.userName = userName;
		this.password = password;
		this.email = email;
                this.typeUser = typeUser;
	}

	public User(String userName, String password, String firstName, String lastName, String email, String typeUser,
			Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.email = email;
                this.typeUser = typeUser;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

        public String getTypeUser() {
            return typeUser;
        }

        public void setTypeUser(String typeUser) {
            this.typeUser = typeUser;
        }
        
        

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

    

    //Insert toString Method

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", password=" 
                + password + ", email=" + email + ", typeUser=" + typeUser 
                + ", roles=" + roles 
                + '}';
    }

    
    
    
    
        
        
	
}
