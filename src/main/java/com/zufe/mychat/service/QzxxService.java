package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Qzxx;

public interface QzxxService {
	public boolean insertOneQz(String qzid, String qzname, String qzcreater);

	public List<Qzxx> getQzxxList(String qzid);

	public List<Qzxx> queryQzxxWithStatus(String qzid, String qzcreater);

	public boolean upDateQzxx(String qzid, boolean yx);

	public boolean disableQzxx(String qzid);

	public boolean SecurySys(String qzid, String username);

	public List<Qzxx> queryQzxxWithQzount(String username);
	
	public List<Qzxx> queryQzxxWithQzcn(String username);
}
