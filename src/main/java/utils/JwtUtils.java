package utils;

import com.getnovel.user.pojo.User;
import io.jsonwebtoken.*;


import java.util.Date;

/***
 * jwt工具类
 */

public class JwtUtils {
    public static  final String SUBJECT = "NOVEL_BACK";
    public static final long EXPIRE = 1000*60; // 过期时间 一周
    public static final  String APPSECRET = "nb666";

    /**
     * 生成token
     * @param user
     * @return
     */

    public  static String generateToken(User user){
        if(user == null || user.getUserId() ==null || user.getAccount()==null){
            return  null;
        }
        String token=Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getUserId())
                .claim("username",user.getAccount())
                .setIssuedAt(new Date()) /*token发行时间*/
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE)) /*过期时间*/
                .signWith(SignatureAlgorithm.HS256,APPSECRET)
                .compact(); /*压缩*/

        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static JwtResult checkToken(String token){
        try {
            final  Claims claims= Jwts.parser().setSigningKey(APPSECRET)
                    .parseClaimsJws(token).getBody();
         String sub = claims.get("sub",String.class);
           return  new JwtResult(true,claims,"合法请求",200);
        } catch (ExpiredJwtException e) {
           return new JwtResult(false,null,"token已过期", 401);
        } catch (SignatureException e){
            return new JwtResult(false,null,"非法请求",400);
        } catch (Exception e){
            return new JwtResult(false,null,"非法请求",400);
        }
    }
}
