package ra.prjmd2.business.designimpl;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {

    @org.junit.jupiter.api.Test
    @DisplayName("login")
    void login() {
        AuthenticationService authenticationService = new AuthenticationService();
        assertNotNull(authenticationService.login("admin123","admin123"));
    }

    @org.junit.jupiter.api.Test
    void register() {
    }
}