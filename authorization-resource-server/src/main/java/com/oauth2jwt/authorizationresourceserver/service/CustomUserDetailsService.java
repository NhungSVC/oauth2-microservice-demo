package com.oauth2jwt.authorizationresourceserver.service;

import com.oauth2jwt.authorizationresourceserver.model.CustomUser;
import com.oauth2jwt.authorizationresourceserver.model.CustomUserDetail;
import com.oauth2jwt.authorizationresourceserver.model.User;
import com.oauth2jwt.authorizationresourceserver.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("nhung");
		userEntity.setPassword("{bcrypt}$2a$12$0NbugyB4hQaCi9.JxGfvk.gDs1/4/K0aXvdDRIyPigtU4HzZBYpji");
		userEntity.setGrantedAuthoritiesList((Collection<GrantedAuthority>) getAuthorities());
		CustomUser customUser = new CustomUser(userEntity);
		return customUser;
		/*User user = new User(1, "nhung",
				"ADMIN", "{bcrypt}$2a$12$0NbugyB4hQaCi9.JxGfvk.gDs1/4/K0aXvdDRIyPigtU4HzZBYpji",
				"1234", "mail", "0985298565", 45, null);
		System.out.println("inside user details Service");
		if(user == null) {
			throw new UsernameNotFoundException(username+" not found");
		}

		return new CustomUserDetail(user);*/
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = new HashSet< >();
		grantedAuthorities.add(new SimpleGrantedAuthority("SUPER_ADMIN"));
		return grantedAuthorities;
	}
}
