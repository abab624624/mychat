package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Ltlb;

public interface LtlbService {

	public List<Ltlb> queryLtlb(String username, String touser);

	public boolean insertContent(String username, String touser, String content);

	public boolean updateContentRead(String username, String touser);
    
	public  List<Ltlb> queryLtlbByTime(String username,String touser); 
		
	
}
