package cc.entity;

import java.io.Serializable;

/**
 * 用户信息 t_user date: 2016年9月6日 下午8:26:37
 * 
 * @author wangyu
 */
public class NewsEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6369545505225528349L;

	private String title;// 标题
	private String writer;// 作者
	private String url;// 图片地址
	private String content;// 内容
	private String enContent;// 内容

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEnContent() {
		return enContent;
	}

	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}
	
	

}