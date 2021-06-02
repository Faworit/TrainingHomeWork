package com.epam.freshnewsrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private String clientid = "test";
    private String clientSecret = "fresh";
    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEowIBAAKCAQEAyFFGyWQaoLuqNdnHFIuqPjmmXZqRjqu/bz32Q8d97KDfATqA\n" +
            "EKOs3NxdaelFAFCNafPp6UtBaqCqsyzEra3iEY9dTwmdVkPGwtyZ0aDKH5UaVZH0\n" +
            "cN0xBYxmUTj1ooCSRr6kvIEbEwYbHiUIk01356ack/YuzlmejOC0xVRhoIi/d1Ou\n" +
            "3tIoAnZRhUY5JSo09sKgznb/q5kYwuTAAcjVaT+NIt855ByITv6yKebqEKj/bHRd\n" +
            "/tc3U7ngVAXxXlGUS3aRRwchzSxSd/AWr1IKZDD+EYF8slIsl1/8CAouNBQBLG3X\n" +
            "Qp5QdewJi88NUGxensrxb/aWC4Il2u0D284OxwIDAQABAoIBAGIZo5/2/S9gGGBc\n" +
            "8aj3KP1mQDow+z2ykILLBnJ1HQ8oTW4NlzAO6BYVeU3n5lncGRUdVZ1htHyiiFZN\n" +
            "A1jHAiJ1Yk3VuI7JjGpbnJzTsIi8/XOQkfQ/7sT32BfI3Eqjyn8I2CZU18x+PgOK\n" +
            "QWPaGXGB38Z6VrvJmeMGHKFSzKjP0XOj/dHligQu3usta53cv736QqxPE08NbClf\n" +
            "KVrFsuRegszBDopAKV45KCPkGivmkYzyfEwX+rApKPWpYhC4FImvPsculVXNCzzy\n" +
            "+nuybpW2DtF4qGUF5vJPO454l66eIrPkz7Nq5SYPmBApjaORNHaIXScePfNQN1+l\n" +
            "FAsWJPkCgYEA63p9s75+Nv3oxt9jDZbsyEC+Z3UTyEmyKKl/amNPIo+Qx7QtsvWi\n" +
            "yoIVovkO7+sFt+f4lSoFtshdounD967NyS3e+MbRjAmvHaYQn8ciMKlJNdn09+4o\n" +
            "Zb1J+gVuwj6MHyBGZ5+W73/IbCYos0ZIrD6O2J4lcVsaks8dW5GcGYsCgYEA2cZY\n" +
            "mPZs6HYe4qJoMWBHCAMbjLBvZjPRKzaeVd3pH14cPq+xkpUehO8mBwXNL0b7HGrW\n" +
            "4U5X56UqOC0RkbivuZXkjCyK9ZysXK1ziI+ojc1nxBKz1cCcgiZxHUyumHcdlHxJ\n" +
            "/iPTYGlVzw9A3NOM/fAMl63bR9os3PrRaBxs7zUCgYEAzeHnDcS77bDKWTbvD+6p\n" +
            "T9zrnOEMTs3AazTnJkl14y3K1BCA9Ds3/f8Gk9tWaAYAle7HtQNsw4cj91CT+nZn\n" +
            "jkIA9Vo/1ESTS0TqvAgLqKgaTm8mc69SusFpcKRXVpYBRSWe6PLrsLL0tToX08bb\n" +
            "u11m35ZF/no9HabgcDM7XEkCgYAyTJawFdLHymiNzhckuGkPl7AoSaQhRfyc74uY\n" +
            "p52tqg36CJiKE7kt2RK+cn+W2N0tDhw9g9vX3BUpTneNYcvsoIteOPeLjTleWo2h\n" +
            "0BSNVBEQf4Vb7JX5lalwrAJzoqeJYT+x3FJ5JTs1jP9dQduB140BB53rNaBBFgmB\n" +
            "83bRtQKBgHDYbvQ7wNOS69YTVxhcunPPMeSFd5v3I2xk4RFCPiUp7Ml0ED6OdM7W\n" +
            "ZSXriTX77lKFoNzdSzyTHLSbIvwA7vU4X3aVlCJyA51qjXA1IxeuAENEPU4cfwbX\n" +
            "rYfr826bnx7NIduzpz0RfxpvSNh6cqCPMExfY0lRJPADHxGLsCJi\n" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyFFGyWQaoLuqNdnHFIuq\n" +
            "PjmmXZqRjqu/bz32Q8d97KDfATqAEKOs3NxdaelFAFCNafPp6UtBaqCqsyzEra3i\n" +
            "EY9dTwmdVkPGwtyZ0aDKH5UaVZH0cN0xBYxmUTj1ooCSRr6kvIEbEwYbHiUIk013\n" +
            "56ack/YuzlmejOC0xVRhoIi/d1Ou3tIoAnZRhUY5JSo09sKgznb/q5kYwuTAAcjV\n" +
            "aT+NIt855ByITv6yKebqEKj/bHRd/tc3U7ngVAXxXlGUS3aRRwchzSxSd/AWr1IK\n" +
            "ZDD+EYF8slIsl1/8CAouNBQBLG3XQp5QdewJi88NUGxensrxb/aWC4Il2u0D284O\n" +
            "xwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }
}
