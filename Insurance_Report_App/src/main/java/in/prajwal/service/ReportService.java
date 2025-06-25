package in.prajwal.service;

import java.util.List;


import in.prajwal.entity.CitizenPlan;
import in.prajwal.request.SearchRequest;

public interface ReportService {
 
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean excelExport();
	
	public boolean pdfExport();
}
