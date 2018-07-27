package cc.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class CommonConst {
	
	/******************** Digit *****************/
	public static final int DIGIT_MINUS_ONE = -1;
	public static final int DIGIT_ZERO = 0;
	public static final int DIGIT_ONE = 1;
	public static final int DIGIT_TWO = 2;
	public static final int DIGIT_THREE = 3;
	public static final int DIGIT_FOUR = 4;
	public static final int DIGIT_FIVE = 5;
	public static final int DIGIT_SIX = 6;
	public static final int DIGIT_SEVEN = 7;
	public static final int DIGIT_EIGHT = 8;
	public static final int DIGIT_NINE = 9;
	public static final int DIGIT_TEN = 10;
	public static final int DIGIT_SIXTEEN = 16;
	public static final int DIGIT_TWENTY = 20;
	public static final int DIGIT_THIRTY = 30;
	public static final int DIGIT_SIXTY = 60;
	public static final int DIGIT_HUNDRED = 100;
	public static final int DIGIT_THOUNDRED = 1000;
	/********************************************/
	
	/************************** Punctuation ***********************/
	public static final String PUNCTUATION_DOT = ".";
	public static final String PUNCTUATION_DOUBLE_QUOTATION_MARKS = "";
	public static final String PUNCTUATION_DOUBLE_QUOTATION_MARKS_BACKSPACE = " ";
	public static final String PUNCTUATION_SEMICOLON=";";
	public static final String PUNCTUATION_HORIZONTAL_LINE = "-";
	public static final String PUNCTUATION_UNDER_LINE = "_";
	public static final String PUNCTUATION_COMMA = ",";
	public static final String PUNCTUATION_NUMBER_SIGN = "#";
	public static final String PUNCTUATION_SPCIAL_SIGN = "/";
	public static final String PUNCTUATION_SQL_PERCENT_SIGN = "%";
	public static final String PUNCTUATION_EMAIL_SIGN = "@";
	/***************************************************************/
	
	/************************** Boolean ***********************/
	public static final Boolean TRUE = true;
	public static final Boolean FALSE = false;
	/***************************************************************/
	
	/********************** Time Format ***********************/
	public static final String TIME_FORMAT = "yyyy-MM-dd hh:mm";
	/***********************************************************/
	
	/********************** File Path & Encrypt ***********************/
	public static final String PATH_CODE_CONFIG_FILE = "/generatorConfig.xml";
	public static final String PATH_MAIL_CONFIG_FILE = "/mail.properties";
	public static final String PATH_SYSTEM_CONFIG_FILE = "/config.properties";
	public static final String PATH_TO_KEY = "/key";
	public static final String UTF8 = "UTF8";
	public static final String ENCRYPT_METHOD_DES = "DES";
	public static final String KEY_STORE_TYPE = "JCEKS";
	public static final char[] SALT = {'j', '3', 'd', '4', '1', 'Z', '#' };
	/***********************************************************/
	
	/********************** Collection ***********************/
	public static Map<String, Object> USER_CACHE_MAP = new HashMap<String, Object>();
	public static Map<String, Object> ROLE_CACHE_MAP = new HashMap<String, Object>();
	public static Map<String, Object> PERMISSION_CACHE_MAP = new HashMap<String, Object>();
	
	public static final String MONGO_KEY_ACCOUNT = "t_account";
	public static final String MONGO_KEY_BONUS = "t_bonus";
	public static final String MONGO_KEY_BONUS_RULE = "t_rule";
	public static final String MONGO_KEY_DEGREE = "t_degree";
	public static final String MONGO_KEY_DICT = "t_dict";
	public static final String MONGO_KEY_LOG = "t_log";
	public static final String MONGO_KEY_MAIL = "t_mail";
	public static final String MONGO_KEY_MESSAGE = "t_message";
	public static final String MONGO_KEY_PERMISSION = "t_permission";
	public static final String MONGO_KEY_ROLE = "t_role";
	public static final String REDIS_MONGO_KEY_ROLE_PERMISSION = "t_role_permission";
	public static final String MONGO_KEY_STOCK = "t_stock";
	public static final String MONGO_KEY_SYSTEM_NOTICE = "t_system_notice";
	public static final String REDIS_MONGO_KEY_USER = "t_user";
	public static final String MONGO_KEY_USER_ACCOUNT = "t_user_account";
	public static final String MONGO_KEY_USER_BONUS = "t_user_bonus";
	public static final String MONGO_KEY_USER_CASH_RECORD = "t_user_cash_record";
	public static final String MONGO_KEY_USER_PROTECT = "t_user_protect";
	public static final String REDIS_MONGO_KEY_USER_ROLE = "t_user_role";
	public static final String MONGO_KEY_USER_STOCK = "t_user_stock";
	public static final String MONGO_KEY_WITHDRAW = "t_withdraw";
	public static final String MONGO_KEY_USER_PERMISSION = "t_user_permission";
	public static final String MONGO_KEY_USER_ORDER = "t_user_order";
	public static final String MONGO_KEY_DATASYNC = "t_db_info";
	
	public static final String REDIS_MONGO_KEY_ALL_USER_ID_USER_NAME = "allUserIDUserName";
	public static final String REDIS_KEY_ROLE_PERMISSION_MAP = "rolePermissionMap_";
	
	public static final String USER_SELECT_LIST = "userSelectList";
	public static final String ROLE_SELECT_LIST = "roleSelectList";
	public static final String PERMISSION_SELECT_LIST = "permissionSelectList";
	
	public static final String PERMISSION = "permission";
	public static final String ALL_PERMISSION = "allPermission";
	public static final String SESSION_USER = "user";
	public static final String SESSION_ROLE = "userRole";
	public static final String RESPONSE_STATUS = "status";
	public static final boolean RESPONSE_STATUS_SUCCESS = true;
	public static final boolean RESPONSE_STATUS_FAIL = false;
	public static final String RESPONSE_ERROR_MESSAGE = "errorMessage";
	public static final String RESPONSE_MESSAGE = "message";
	/***********************************************************/
	
	/********************** Picture Format ***********************/
	public static final String PIC_FORMAT_JPG = "jpg";
	public static final String PIC_FORMAT_PNG = "PNG";
	/***********************************************************/
	
	/******************** Mail ********************/
	public static final String MAIL_SMTP_HOST_URL = "mail.smtp.host";
	public static final String MAIL_PORT = "mail.port";
	public static final String MAIL_ADDRESS_PASSORD = "password.mail";
	public static final String MAIL_ADDRESS_BACKEND = "backend.mail";
	public static final String MAIL_ADDRESS_FUND = "fund.mail";
	public static final String MAIL_ADDRESS_FUND_SERVICE = "fundservice.mail";
	public static final String MAIL_ADDRESS_VIP_HELP = "viphelp.mail";
	public static final String MAIL_USERNAME_PASSWORD = "mail.password.username";
	public static final String MAIL_USERNAME_BACKEND = "mail.backend.username";
	public static final String MAIL_USERNAME_FUND = "mail.fund.username";
	public static final String MAIL_USERNAME_FUND_SERVICE = "mail.fundservice.username";
	public static final String MAIL_USERNAME_VIP_HELPER = "mail.viphelp.username";
	public static final String MAIL_PASSWORD = "mail.password";
	/*******************************************************/
	
	
	/******************** Dictionary ********************/
	public static final String DICTIONARY_SMSSEND_GROUP = "SMS_SEND_MODEL";
	
	/***************************************************/
	
	/********************** APP user url ***********************/
	public static final String APP_USER_URL = "http://cd.wlsd.com.cn/api/member/?mall_db=592003&auth_code=d2WPQsWvNArX1M0l&data_version=1.0.0&data_type=1";
	/***********************************************************/
	
	/********************** App seller url ***********************/
	public static final String APP_SELLER_URL = "http://cd.wlsd.com.cn/api/store/?mall_db=592003&auth_code=d2WPQsWvNArX1M0l&data_version=&data_type=1";
	/***********************************************************/
	
	/********************** weixinUrl ***********************/
	public static final String WECHAT_HOME_QUERY_URL = "http://wx.chwqf.com/Index/needvip";//"http://wx.chwqf.com/Index/needvip";
	/********************** weixinUrl ***********************/
	public static final String WECHAT_HOME_UPDATE_URL = "http://wx.chwqf.com/Index/changevip?info=success&orderid=";

	/********************** mobile code ***********************/
	public static final String SEND_URL = "http://www.smsadmin.cn/smsmarketing/wwwroot/api/post_send/";
	public static final String SEND_UID = " shenzhen8288";
	public static final String SEND_PWD = "shen1qazxsw2";
	public static final String SEND_CODE = "sendCode";
	/***********************************************************/
	/********************** Ĭ������ ***********************/
	public static final String USER_PWD = "111111";
	/***********************************************************/
	
	/*********************************** ΢********************************/
	public static String APPID = "wx1e391c310348c06b";//
	public static String MCHID = "1343496101";//
	public static String APPSECRET = "a3ceed7176d3efca7d31953b92d4154d";//
	public static String KEY = "qwertyuiqwertyuiqwertyui12345678";	//
	public static String WEIXINPAY_SUBJECT = "众商基金";	//
	public static String NOTIFY_URL = "pay/wxPcnotify.html";//	//
	public static String CREATEORDERURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";//
    
	/*********************************** ΢********************************/
	public static String AUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";
	public static String REDIRECT_URL = "mmp/pay/wxPhonetoCreatePay.do";//�ض����ַ
	public static String GETTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";//getToken
	public static String GETOPENID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";	//��ȡopenId
	public static String AUTH_ROOT = "fund/wx";	//
	
	/********************************************************************/
	
	/***********************************alipay********************************/
	
	public static String ALIPAY_SUBJECT = "众商基金";	//
	public static String ALIPAY_NOTIFY_URL = "pay/alipay_result_notify.html";//	
	public static String SHOW_URL = "/user/userInvest.html";//
	public static String ALIPAY_RETURN_URL = "pay/alipay_result.html";
	public static String PARTNER        = "2088221937055572";
	public static String SELLER_ID      = PARTNER;
    public static String ALIPAY_MOBILE_PUBLIC_KEY  = " MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDLKtNrxzb+j4TrdTSWEjVfuit2tOLeemPeTKuY3DoNWjES1riYm53BQkAK/laIxFbfoiM973z810lXhZf6wc9GkqYMwT5oY9hxQ9ihECqj3nSxVcOSE6IK85+Ed7fc008dEOICnfYeYXFEATbWcKaDDSaY7GvzNG3KXxpsUrCrlQIDAQAB";
    public static String ALIPAY_MOBILE_PRIVATE_KEY  = "7ah7hh3cznvrqvzxkzpe4ppp0zvz88am";
    public static String LOG_PATH       = "C:\\";
    public static String INPUT_CHARSET  = "utf-8";
    public static String SIGN_TYPE      = "MD5";
	
	/***********************************alipay*******************************/
    public static String PICTURE_STO_URL      = "temp/";
    public static String PICTURE_VIS_URL      = ":8089/picture/news/";
	/********************** ***********************/
	public static final String OPEN_PRICE = "100";
	public static final String CASH_INTEGRAL_UNIT_PRICE = "1";
	public static final String AWARD_REGISTER_USER = "100";
	public static final Integer USER_OPEN_ACCOUNT = 1;
	public static final Integer USER_CLOSE_ACCOUNT = 0;
	public static final String USER_AWORD_RATIO = "0.3";
	public static final String USER_CASH_AWORD_RATIO = "0.1";
	/***********************************************************/
	
	/*********************************************/
	public static final String CHIHUO_SQL_URL = "jdbc:mysql://localhost:3306/mmp?characterEncoding=utf-8";
	public static final String CHIHUO_SQL_USER_NAME = "root";
	public static final String CHIHUO_SQL_PASSWORD = "root";
	/***********************************************************/
	
	/*********************************************/
	public static final String HUILIAN_SQL_URL = "jdbc:mysql://122.114.113.225:13306/mmp?characterEncoding=utf-8";
	public static final String HUILIAN_USER_NAME = "wxchwqf";
	public static final String HUILIAN_PASSWORD = "wxchwqf$%727";
	/***********************************************************/
	
	/**********************weixn settle**********************/
	public static final String REGISTER_REWARD_INTEGRAL = "1000";
	public static final String REGISTER_REWARD_STOCK = "100";
	public static final String RECOMMED_REWARD1 = "0.2";
	public static final String RECOMMED_REWARD2 = "0.1";
	public static final String RECOMMED_REWARD3 = "0.2";
	
	public static final String UP_GIVE_LEAVE = "0.8";
	public static final String UP_GIVE_REDIO = "0.2";
	public static final String INTEGRAL_TO_REWORD_REDIO = "0.2";
	public static final String INTEGRAL_TO_SHOP_REDIO = "0.5";
	public static final String STOCK_PRICE = "3";
	
	public static final String WITHDRAW_SHOP = "0.05";
	public static final String WITHDRAW_HAND = "0.02";
	public static final String WITHDRAW_TAX = "0.02";
	public static final String WITHDRAW_LOVE = "0.01";
	public static final String WITHDRAW_STOCK = "0.05";
	public static final String WITHDRAW_STAY = "0.85";
	/***********************************************************/
	
	/********************投资金额***************************************/
	public static final String INVEST_MONEY_LEVEL_1 = "500"; 
	public static final String INVEST_MONEY_LEVEL_2 = "1000"; 
	public static final String INVEST_MONEY_LEVEL_3 = "3000"; 
	public static final String INVEST_MONEY_LEVEL_4 = "6000"; 
	public static final String INVEST_MONEY_LEVEL_5 = "10000"; 
	/***********************************************************/
	
	static {
		InputStream in = CommonConst.class.getResourceAsStream(PATH_MAIL_CONFIG_FILE);
		Properties prop = new Properties();
		try {
			prop.load(in);
			USER_CACHE_MAP.put(MAIL_SMTP_HOST_URL, prop.get(MAIL_SMTP_HOST_URL));
			USER_CACHE_MAP.put(MAIL_PORT, prop.get(MAIL_PORT));
			USER_CACHE_MAP.put(MAIL_ADDRESS_PASSORD, prop.get(MAIL_ADDRESS_PASSORD));
			USER_CACHE_MAP.put(MAIL_ADDRESS_BACKEND, prop.get(MAIL_ADDRESS_BACKEND));
			USER_CACHE_MAP.put(MAIL_ADDRESS_FUND, prop.get(MAIL_ADDRESS_FUND));
			USER_CACHE_MAP.put(MAIL_ADDRESS_FUND_SERVICE, prop.get(MAIL_ADDRESS_FUND_SERVICE));
			USER_CACHE_MAP.put(MAIL_ADDRESS_VIP_HELP, prop.get(MAIL_ADDRESS_VIP_HELP));
			USER_CACHE_MAP.put(MAIL_USERNAME_PASSWORD, prop.get(MAIL_USERNAME_PASSWORD));
			USER_CACHE_MAP.put(MAIL_USERNAME_BACKEND, prop.get(MAIL_USERNAME_BACKEND));
			USER_CACHE_MAP.put(MAIL_USERNAME_FUND, prop.get(MAIL_USERNAME_FUND));
			USER_CACHE_MAP.put(MAIL_USERNAME_FUND_SERVICE, prop.get(MAIL_USERNAME_FUND_SERVICE));
			USER_CACHE_MAP.put(MAIL_USERNAME_VIP_HELPER, prop.get(MAIL_USERNAME_VIP_HELPER));
			USER_CACHE_MAP.put(MAIL_PASSWORD, prop.get(MAIL_PASSWORD));
		} catch (IOException e) {
			System.out.println("Initial Mail Resources Failed.");
			e.printStackTrace();
		}
	}
}