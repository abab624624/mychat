package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Qzcount;

public interface QzcountService {
	public boolean insertOneQzcount(String qzid);

	public List<Qzcount> queryQzcount(String qzid);

	public boolean updateQzcount(String qzid, int count);

	public boolean addQzCount(String qzid);

	public boolean reduceQzCount(String qzid);
}
