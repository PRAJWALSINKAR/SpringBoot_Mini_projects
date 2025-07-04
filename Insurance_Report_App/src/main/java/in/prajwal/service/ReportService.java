package in.prajwal.service;

import java.util.List;


import in.prajwal.entity.CitizenPlan;
import in.prajwal.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
 
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel(HttpServletResponse response, SearchRequest request)throws Exception;

	public boolean exportdf(HttpServletResponse response)throws Exception;
}
