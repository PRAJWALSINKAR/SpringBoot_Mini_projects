package in.prajwal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.prajwal.entity.CitizenPlan;
import in.prajwal.repo.CitizenPlanRepository;
import in.prajwal.request.SearchRequest;

@Service
public class ServiceImpl implements ReportService {
     
	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		// TODO Auto-generated method stub
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean excelExport() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pdfExport() {
		// TODO Auto-generated method stub
		return false;
	}

}
