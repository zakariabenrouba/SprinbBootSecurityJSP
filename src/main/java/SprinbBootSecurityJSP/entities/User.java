package SprinbBootSecurityJSP.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	@Column(unique=true)
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String firstName, String email, String cin, String username, String password,
			Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getIdUser() {
		return user_id;
	}

	public void setIdUser(int idUser) {
		this.user_id = idUser;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [idUser=" + user_id + 
				
				
				", username=" + username + ", password=" + password + ", role=" + role + "]";
	}


	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		if(user==null) return false;
		if(user.getIdUser()!=this.user_id)return false;
		return true;
	}
	
}	
