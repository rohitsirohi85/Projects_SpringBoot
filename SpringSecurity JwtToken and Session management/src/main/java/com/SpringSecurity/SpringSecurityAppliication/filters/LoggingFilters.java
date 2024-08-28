package com.SpringSecurity.SpringSecurityAppliication.filters;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingFilters extends OncePerRequestFilter{

     private static final Logger logger = LoggerFactory.getLogger(LoggingFilters.class);
    

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
           logger.info("Incoming request : {}{}",request.getMethod() , request.getRequestURI());
           filterChain.doFilter(request, response);
           logger.info("Outgoing request : {}{}",response.getStatus() , response.getContentType());
    }
    
        

}
