package com.flyingfish.infrastructure.authentication;

import com.flyingfish.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService implements IClientSerivice {

//    private static final long serialVersionUID = 8417378025084275560L;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client = this.clientRepository.findByClientId(clientId);
        client.setClientSecret(new BCryptPasswordEncoder().encode(client.getClientSecret()));
        List<String> scopes = new ArrayList<>();
        scopes.add("app");
        client.setScope(scopes);

        List<String> grantTypes = new ArrayList<>();
        grantTypes.add("password");
        grantTypes.add("refresh_token");
        client.setAuthorizedGrantTypes(grantTypes);

//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return "test";
//            }
//        });
//        client.setAuthorities(authorities);
        return client;
    }
}
