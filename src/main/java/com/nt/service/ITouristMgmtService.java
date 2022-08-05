package com.nt.service;

import com.nt.entity.Tourist;

public interface ITouristMgmtService {
	public String register(Tourist tourist);
	public List<Tourist> get AllTourist(Tourist tourist);
}
