package br.com.breakfastapp.server.security.domains;

public class SecurityConstants {
    public static final String SECRET = "BreakFastAppNoww!";
    public static final long EXPIRATION_TIME = 86400000; // 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}