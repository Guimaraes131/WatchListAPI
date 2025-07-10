package io.github.Guimaraes131.watchlistapi.security;

import io.github.Guimaraes131.watchlistapi.model.User;
import io.github.Guimaraes131.watchlistapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityService {

    private final UserService service;

    public User getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) auth.getPrincipal();

        return service.getByLogin(user.getUsername());
    }
}
