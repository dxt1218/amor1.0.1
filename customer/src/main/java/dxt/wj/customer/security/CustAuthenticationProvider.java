package dxt.wj.customer.security;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * 自定义 认证
 * */
public class CustAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginName =authentication.getName();
        String password =authentication.getDetails().toString();

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
