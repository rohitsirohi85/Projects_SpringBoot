package com.SpringSecurity.SpringSecurityAppliication.services;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import com.SpringSecurity.SpringSecurityAppliication.Entity.Session;
import com.SpringSecurity.SpringSecurityAppliication.Entity.User;
import com.SpringSecurity.SpringSecurityAppliication.repo.SessionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepo sessionRepo;
    private int SESSION_LIMIT=2;

    public void generateSession(User user , String token){
        List<Session> userSessions = sessionRepo.findByUser(user);
        if (userSessions.size()==SESSION_LIMIT) {
            userSessions.sort(Comparator.comparing(Session::getLastUsedAt));
            Session leastRecentlyUsedSession = userSessions.getFirst();
            sessionRepo.delete(leastRecentlyUsedSession);
        }
        //if session limit not exceeded
        Session newSession = Session.builder()
                         .user(user)
                         .token(token)
                         .build();
                         sessionRepo.save(newSession);
    }

    public void validate(String token){
        Session session = sessionRepo.findByToken(token).orElseThrow(()->new SessionAuthenticationException("token not found"));
        session.setLastUsedAt(LocalDateTime.now());
        sessionRepo.save(session);
    }
    
}
