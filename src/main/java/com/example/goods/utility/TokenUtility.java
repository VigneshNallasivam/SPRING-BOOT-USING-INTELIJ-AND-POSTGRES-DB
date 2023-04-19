package com.example.goods.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

@Component
public class TokenUtility
{
    private static final String TOKEN_SECRET = "GateKeeper";
    public String createToken(int rollNo)
    {
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            String token = JWT.create()
                    .withClaim("roll_id",rollNo)
                    .sign(algorithm);
            return token;
        }
        catch (JWTCreationException exception)
        {
            exception.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public int decodeToken(String token)
    {
        int rollNo;
        Verification verification = null;
        try
        {
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        }
        catch (IllegalArgumentException  e)
        {
            e.printStackTrace();
        }
        JWTVerifier jwtverifier = verification.build();
        DecodedJWT decodedjwt=jwtverifier.verify(token);
        Claim claim=decodedjwt.getClaim("roll_id");
        rollNo = claim.asInt();
        return rollNo;
    }
}
