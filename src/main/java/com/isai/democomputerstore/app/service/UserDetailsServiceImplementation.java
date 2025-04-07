package com.isai.democomputerstore.app.service;

import com.isai.democomputerstore.app.models.entitys.User;
import com.isai.democomputerstore.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
personalizada del servicio de autenticación de Spring Security
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation
        implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userBD = userRepository.findUserByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario "
                        .concat(username).concat(" no existe")));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        //get roles
        userBD.getRoles()
                .forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleName().name())));
                });
        //get permisos
        userBD.getRoles()
                .stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> {
                    authorities.add(new SimpleGrantedAuthority(permission.getNamePermission()));
                });

        return new org.springframework.security.core.userdetails.User(
                userBD.getUserName(),
                userBD.getUserPasswor(),
                userBD.getIsEnabled(),
                userBD.getAccountNonExpired(),
                userBD.getCredentialsNonExpired(),
                userBD.getAccountNonLocked(),
                authorities
        );
    }
}
