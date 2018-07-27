package cc.utils;

import cc.common.CommonConst;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@SuppressWarnings("deprecation")
public class StringUtils {
	
	/** 年月日时分秒(无下划线) yyMMddHHmmss */
    public static final String DATE_FORMAT = "yyMMddHHmmssSSS";

	public static boolean containsNumber(String str) {
		
		char[] ch = str.toCharArray();
		
		if(null != ch && ch.length > CommonConst.DIGIT_ZERO) {
			for(int i = CommonConst.DIGIT_ZERO, len = ch.length; i < len; i++) {
				boolean isNumber = Character.isDigit(ch[i]);
				if(!isNumber){
					return false;
				}
			}
		}
		return true;
	}
	
	public static String produceUUID() {
		return String.valueOf(java.util.UUID.randomUUID()).replaceAll(CommonConst.PUNCTUATION_HORIZONTAL_LINE, CommonConst.PUNCTUATION_DOUBLE_QUOTATION_MARKS);
	}
	
	/**
     * 产生随机字符串
     * 
     * @param length
     * @return
     */
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
        Random random = new Random();   
        StringBuffer sb = new StringBuffer();   
        for (int i = 0; i < length; i++) {   
            int number = random.nextInt(base.length());   
            sb.append(base.charAt(number));   
        }   
        return sb.toString();   
     }  
	
    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     * @return
     *      以yyMMddHHmmss为格式的当前系统时间+2位随机数
     */
    public static String getOrderSn() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        String sn = df.format(date);
        sn += RandomUtil.randomNumber(2);
        return sn;
    }
    
	public static void main(String[] args) {
		System.out.println(StringUtils.produceUUID());
		System.out.println(StringUtils.produceUUID());
		System.out.println(StringUtils.produceUUID());
		System.out.println(StringUtils.produceUUID());
		System.out.println(StringUtils.produceUUID());
		System.out.println(StringUtils.produceUUID());
		System.out.println(StringUtils.produceUUID());
	}
	
	public static int send(String mobile, String message) {

		try {
			HttpPost httpPost = new HttpPost(CommonConst.SEND_URL);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("uid", CommonConst.SEND_UID));
			nvps.add(new BasicNameValuePair("pwd", CommonConst.SEND_PWD));
			nvps.add(new BasicNameValuePair("mobile", mobile));
			nvps.add(new BasicNameValuePair("msg", message));

			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "GB2312"));
			@SuppressWarnings("resource")
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = httpclient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return 1;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 1;

	}
	
	public static boolean isBlank(String toTest) {
		return ((toTest == null) || (toTest.length() == 0));
	}
	
}
