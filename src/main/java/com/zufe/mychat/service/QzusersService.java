package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Qzusers;

public interface QzusersService {

	public boolean insertOneQzUser(String qzid, String username);

	public List<Qzusers> queryQzusers(String qzid, String username);

	public boolean UpdateQzusers(String qzid, String username, Boolean yx);

	public boolean leaveOneQz(String qzid, String username);
	
	public boolean checkQzUsers(String username,String qzid); 
	
	public List<Qzusers> queryQzusersWithYx(String qzid,String username);
	

}
