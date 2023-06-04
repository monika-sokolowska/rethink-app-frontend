package com.example.backend.security;

import com.example.backend.model.User;
import com.example.backend.security.services.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class Utils {
    public static UserDetailsImpl GetCurrentUser() {
        return (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}