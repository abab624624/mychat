package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Invites;

public interface InvitesService {

	public void InsertInvites(String sender, String receiver, String message);

	public int QueryInvitesCount(String username);

	public List<Invites> QueryInvites(String username);

	public boolean DeleteInvites(String sender, String receiver);

	public boolean UpdateInvites(String sender, String receiver);
	
	public boolean CheckInvites(String sender,String receiver);

}
