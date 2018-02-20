package SprinbBootSecurityJSP.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SprinbBootSecurityJSP.dao.UserRepository;
import SprinbBootSecurityJSP.entities.User;


@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(arg0);
		if(user==null)
			throw new UsernameNotFoundException("Username : "+arg0+" not found");
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities(user));
	}
	
	private Collection<GrantedAuthority> grantedAuthorities(User user)
	{
		Collection<GrantedAuthority> ga=new ArrayList<GrantedAuthority>();
		if(user.getRole().getRole().equalsIgnoreCase("ADMIN")) {
			ga.add(new SimpleGrantedAuthority("ROLE_ADMIN"));}
		ga.add(new SimpleGrantedAuthority("ROLE_USER"));	
		return ga;
	}
}
