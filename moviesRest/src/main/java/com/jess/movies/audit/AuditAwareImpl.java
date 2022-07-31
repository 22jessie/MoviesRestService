/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jess.movies.audit;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author jessica-22
 */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String>{
    
    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
