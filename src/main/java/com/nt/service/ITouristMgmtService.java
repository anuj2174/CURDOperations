package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;

public interface ITouristMgmtService {
	public String register(Tourist tourist);
	public List<Tourist> getAllTourist();
}
