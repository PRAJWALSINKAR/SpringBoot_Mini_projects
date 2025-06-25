package in.prajwal.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
		
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		CitizenPlan entity = new CitizenPlan();
		
         if(null != request.getPlanName() && !"".equals(request.getPlanName())){
		 entity.setPlanName(request.getPlanName());
	}
	
	  if(null != request.getPlanStatus() && !"".equals(request.getPlanStatus())){
		 entity.setPlanStatus(request.getPlanStatus());
	}
	  
	  if(null != request.getGender() && !"".equals(request.getGender())){
			 entity.setGender(request.getGender());
		}
	  
	  if(null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate =  LocalDate.parse(startDate,formatter);
			entity.setPlanStartDate(localDate);
			
		}
	
	
	 if(null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate =  LocalDate.parse(endDate,formatter);
			entity.setPlanEndDate(localDate);
			
		}
		
		return repo.findAll(Example.of(entity));
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
