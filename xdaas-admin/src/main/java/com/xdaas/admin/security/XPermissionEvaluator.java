package com.xdaas.admin.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * 配合使用注解  @PreAuthorize("hasPermission()")等
 * @author mathc
 * Created on 2020/10/27
 */
@Configuration
public class XPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean accessable = false;
        if(authentication.getPrincipal().toString().compareToIgnoreCase("anonymousUser") != 0){
            String privilege = targetDomainObject + "-" + permission;
            for(GrantedAuthority authority : authentication.getAuthorities()){
                if(privilege.equalsIgnoreCase(authority.getAuthority())){
                    accessable = true;
                    break;
                }
            }

            return accessable;
        }

        return accessable;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
