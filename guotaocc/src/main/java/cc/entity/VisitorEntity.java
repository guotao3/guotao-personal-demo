package cc.entity;

import java.io.Serializable;

/**
 * 用户信息 t_user date: 2016年9月6日 下午8:26:37
 * 
 * @author wangyu
 */
public class VisitorEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6369545505225528349L;

	private String visitorName;// 标题
	private String subject;// 作者
	private String email;// 图片地址
	private String content;// 内容
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

}