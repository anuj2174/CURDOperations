package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristrepo;
	@Override
	public String register(Tourist tourist) {
		int idVal = touristrepo.save(tourist).getTId();
		return "Tourist is Registered  having id ::"+idVal;
	}

	
  public List<Tourist> getAllTourist(){
	List<Tourist> list = touristrepo.findAll();
	list.sort((t1,t2)->t1.getTId().compareTo(t2.getTId()));
	return list;
}

}
