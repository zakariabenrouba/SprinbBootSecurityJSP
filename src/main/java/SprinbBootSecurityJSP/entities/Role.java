package SprinbBootSecurityJSP.entities;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int role_id;
	private String role;
	
	@OneToMany(targetEntity=User.class,fetch=FetchType.LAZY,mappedBy="role",cascade=CascadeType.ALL)
	private Set<User> users;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public int getIdRole() {
		return role_id;
	}

	public void setIdRole(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return "Role [idRole=" + role_id + ", role=" + role + "]";
	}
	
	
}
