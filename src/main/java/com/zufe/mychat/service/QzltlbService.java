package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Qzltlb;



public interface QzltlbService {



	public List<Qzltlb> queryQzLtlb(String username, String qzid);

	public boolean insertQzContent(String username, String qzid, String content);

	
	
	public List<Qzltlb> queryQzLtlbByTime(String qzid);
}
