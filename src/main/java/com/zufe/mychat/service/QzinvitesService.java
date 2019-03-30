package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Qzinvites;

public interface QzinvitesService {

	public boolean insertQzinvites(String sender, String qzid, String message);

	public boolean updateQzinvites(String sender, String qzid, String message,
			boolean status);

	public List<Qzinvites> queryQzinvites(String sender, String qzid);

	public List<Qzinvites> queryQzinvitesByCreater(String username);

	public boolean clearQzinvites(String sender, String qzid);
	
	public boolean reloadQzinvites(String sender, String qzid);
    
	public boolean checkQzinvites(String sender,String qzid);
}
