package plus.planner.subpartservice.logic;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.*;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

public class JwtLogic {
    public void CreateJwtToken() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(1024);

        KeyPair kp = keyGenerator.genKeyPair();
        PublicKey publicKey = (PublicKey) kp.getPublic();
        String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println(encodedPublicKey);
        PrivateKey privateKey = (PrivateKey) kp.getPrivate();
        String token = generateJwtToken(privateKey);
        Jws parseClaimsJws = Jwts.parser().setSigningKey(publicKey)
                .parseClaimsJws(token);
        System.out.println(token);
        System.out.println(parseClaimsJws);
    }

    @SuppressWarnings("deprecation")
    public String generateJwtToken(PrivateKey privateKey) {
        //TODO change the token builder values to actually needed versions
        String token = Jwts.builder().setSubject("adam")
                .setExpiration(addHoursToJavaUtilDate(new Date(System.currentTimeMillis()), 1))
                .setIssuer("info@wstutorial.com")
                .claim("groups", new String[] { "user", "admin" })
                // RS256 with privateKey
                .signWith(SignatureAlgorithm.RS256, privateKey).compact();
        return token;
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        System.out.println(calendar.getTime());
        return calendar.getTime();
    }
}
