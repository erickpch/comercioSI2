package com.tienda.comercio.Service;

import com.tienda.comercio.Repositorio.UserRepository;
import com.tienda.comercio.model.Rol;
import com.tienda.comercio.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Buscar al usuario por nombre de usuario
        Usuarios userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        // Obtener el rol del usuario
        Rol userRole = userEntity.getId_rol();  // Obtiene el rol único del usuario



        Collection<? extends GrantedAuthority> authorities = userEntity.getId_rol().getId_rol_permiso().stream().map(permition->
                        new SimpleGrantedAuthority("ROLE_".concat(permition.getId_permiso().getPermiso())))
                .collect(Collectors.toSet());



        return new User(userEntity.getUsername(), userEntity.getPassword(), true, true, true, true, authorities);
    }
}
