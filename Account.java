package lms.vo;

public class Account {
	private String id;
	private String pwd;
	
	public Account(String tId, String tPwd)
	{
		this.id =tId;
		this.pwd =tPwd;
	}
	
	
	public String getId()
	
	{
		return id;
			}
	public void setID(String tid)
	{
		this.id =tid;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String tPwd)
	{
		this.pwd =tPwd;
	}

}


