package com.java.learn;

import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.linkwan.model.v20181230.SendUnicastCommandRequest;
import com.aliyuncs.linkwan.model.v20181230.SendUnicastCommandResponse;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hello world!
 *
 */
@Slf4j
public class App {

    private static final char LOWER_A = 'a';
    private static final char LOWER_F = 'f';
    private static final char UPPER_A = 'A';
    private static final char UPPER_F = 'F';
    private static final char CHAR_0 = '0';
    private static final char CHAR_9 = '9';
    private static final int MAX_EUI_LENGTH = 16;

    @Autowired
    private static Action<String> action;

    private static final byte[] DEFAULT_XOR_BYTES = new byte[] { (byte)0x97, (byte)0x0A, (byte)0xE6,
        (byte)0xAA, (byte)0xBB, (byte)0xCC, (byte)0xDD,(byte)0x00 };

    private static final String PRODUCT_NAME_REGEX = "^[\u4e00-\u9fa5_a-zA-Z0-9]{4,30}$";

    public static final String REP_EUI = "^" + "d896e0" + "[0-9a-f]{10}";

    private static final String ALI_CLOUD_IOT = "AliCloud IoT";

    public static void main( String[] args ) {

        //String test = "'abcdefg'";
        //log.info("test={}", test.replace("_", "\\_"));
        ////log.info("test={}", test.substring(0, 1024));

        //String testa = "abc?";
        //String value = "$";
        //String sql = testa.replaceFirst("\\?", value);
        //log.info(sql);

        String gwEui = "d896e0fff00001e0";
        Long eui = getEuiFromString(gwEui);
        log.info("eui={}", gwEui.substring(0, 3));

        String basic = "starterkit:d703f52b-1200-4318-ae0d-0f6092b2e6ab";
        log.info("base64 ={}", Base64.getMimeEncoder().encodeToString(basic.getBytes()));

        String test = "NodeTuple.DEVEUI";
        log.info("log={}", test.substring(test.indexOf('.') + 1, test.length()));

        log.info("long = {}", Long.MAX_VALUE);

        String num = "9223372036854775807";
        //89860616010049046168
        //9223372036854775807

        BigInteger bigInteger = new BigInteger("89860616010049046168");
        log.info("bigInteger={}", bigInteger);

        String inputDate = "2019-03-07 07:13:27.109+0000";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSZ");
            ZonedDateTime zdt = ZonedDateTime.parse("2019-03-07 07:13:27.109+0000", f);
            Date date = sdf.parse(inputDate);
            log.info("date={}", date);
        }catch (Exception e) {
            log.info("e={}", e);
        }




        //String regionId = "cn-shanghai";
        //String accessKeyId = "<您账号的AccessKeyId, 支持子账号>";
        //String accessKeySecret = "<您账号的AccessKeySecret, 支持子账号>";
        //DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        //IAcsClient client = new DefaultAcsClient(profile);
        //SendUnicastCommandRequest request = new SendUnicastCommandRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        //request.setMethod(MethodType.POST);
        //request.setDevEui("0000000000000000");
        //request.setMaxRetries(0);
        //request.setFPort(0);
        //request.setComfirmed(false);
        //request.setCleanUp(false);
        //request.setContent("00000000");
        //SendUnicastCommandResponse response = client.getAcsResponse(request);
        //System.out.println(response);

        //String productName = "a";
        //Boolean result = productName.matches(PRODUCT_NAME_REGEX);
        //try {
        //    byte[] bytes = productName.getBytes("gbk");
        //    long length = bytes.length;
        //    log.info("length={}", length);
        //} catch (UnsupportedEncodingException e) {
        //    log.info("error");
        //}
        //log.info("result={}", result);

        //List<String> topics = new ArrayList<>(2);
        //topics.add("erlei_test");
        //topics.add("erlei_test_1");
        //Boolean result = topics.contains("erlei_test");
        //log.info("hello world");
        //
        //String regs="([^\\u4e00-\\u9fa5\\w\\(\\)（）])+?";
        //
        //Pattern pattern= Pattern.compile(regs);
        //
        //String testStr="hh??++h(!@#$%^&*)!@#$%^&*^&*ha对数据";
        //
        //Matcher matcher=pattern.matcher(testStr);
        //
        //testStr = matcher.replaceAll("");
        //
        //Long longVal = 52366L;
        //
        //// 通过 ByteBuffer 进行 base64 加密
        //ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        //buffer.putLong(longVal);
        //
        //for (int i = 0; i < buffer.limit(); i++) {
        //    buffer.put(i, (byte)(buffer.get(i) ^ DEFAULT_XOR_BYTES[i])) ;
        //}
        //
        //String stringVal = Base64.getEncoder().encodeToString(buffer.array());
        //log.info(stringVal);


        //// 通过 Longs.toByteArray 进行 base64 加密
        //byte[] bytes = Longs.toByteArray(longVal);
        //for (int i = 0; i < bytes.length; i++) {
        //    bytes[i] ^= DEFAULT_XOR_BYTES[i];
        //}
        //stringVal = Base64.getEncoder().encodeToString(bytes);
        //log.info(stringVal);
        //
        //// 解密
        //byte[] newBytes = Base64.getDecoder().decode(stringVal);
        //buffer = ByteBuffer.allocate(Long.BYTES);
        //buffer.put(newBytes);
        //buffer.flip();
        //
        //for (int i = 0; i < buffer.limit(); i++) {
        //    buffer.put(i, (byte)(buffer.get(i) ^ DEFAULT_XOR_BYTES[i])) ;
        //}
        //
        //longVal = buffer.getLong();
        //log.info(longVal.toString());


    }

    private static void print () {
        String abd  = "";
        action.print(abd);
    }

    public static long getEuiFromString(String euiText) {
        if (euiText.length() > MAX_EUI_LENGTH) {
            throw new IllegalArgumentException();
        }
        long eui = 0;
        byte[] bytes = euiText.getBytes();
        for (byte single : bytes) {
            eui = (eui << 4) | translateHexCharacter((char)single);
        }
        return eui;
    }

    private static byte translateHexCharacter(char hexChar) {
        if (hexChar >= LOWER_A && hexChar <= LOWER_F) {
            return (byte)(hexChar - LOWER_A + 10);
        }
        if (hexChar >= UPPER_A && hexChar <= UPPER_F) {
            return (byte)(hexChar - UPPER_A + 10);
        }
        if (hexChar >= CHAR_0 && hexChar <= CHAR_9) {
            return (byte)(hexChar - CHAR_0);
        }
        throw new IllegalArgumentException();
    }

}
