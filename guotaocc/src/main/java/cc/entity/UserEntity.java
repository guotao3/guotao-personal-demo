package cc.entity;

import java.io.Serializable;

public class UserEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8423297304074729327L;
	
	private String  wxId;
    private String  userIdNum;
    private String  userRealName;
    private String  userPassword;
    private String  userMobile;
    private String  userEmail;
    private String  shopIntegral;
    private String  activeIntegral;
    private String  registerIntegral;
    private String  fund;
    private String  bonus;
    private String  otherBuyIntegral;
    private String  stock;
    private String  investment;
    private String  userParentName;
    private String  country;
    private String  IDType;
    
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public String getUserIdNum() {
		return userIdNum;
	}
	public void setUserIdNum(String userIdNum) {
		this.userIdNum = userIdNum;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getShopIntegral() {
		return shopIntegral;
	}
	public void setShopIntegral(String shopIntegral) {
		this.shopIntegral = shopIntegral;
	}
	public String getActiveIntegral() {
		return activeIntegral;
	}
	public void setActiveIntegral(String activeIntegral) {
		this.activeIntegral = activeIntegral;
	}
	public String getRegisterIntegral() {
		return registerIntegral;
	}
	public void setRegisterIntegral(String registerIntegral) {
		this.registerIntegral = registerIntegral;
	}
	public String getFund() {
		return fund;
	}
	public void setFund(String fund) {
		this.fund = fund;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getOtherBuyIntegral() {
		return otherBuyIntegral;
	}
	public void setOtherBuyIntegral(String otherBuyIntegral) {
		this.otherBuyIntegral = otherBuyIntegral;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getInvestment() {
		return investment;
	}
	public void setInvestment(String investment) {
		this.investment = investment;
	}
	public String getUserParentName() {
		return userParentName;
	}
	public void setUserParentName(String userParentName) {
		this.userParentName = userParentName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIDType() {
		return IDType;
	}
	public void setIDType(String iDType) {
		IDType = iDType;
	}
	
  
	
}