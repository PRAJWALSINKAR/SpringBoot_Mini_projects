package in.prajwal.service;

import java.util.List;



import in.prajwal.binding.DashBoardResponse;
import in.prajwal.binding.EnquiryForm;
import in.prajwal.binding.EnquirySearchFilter;
import in.prajwal.entity.StudentEnqEntity;

public interface EnquiryService {
	public List<String> getCourseName();
	
	public List<String> getEnqStatus();
	
	public DashBoardResponse getDashboardData(Integer userId);
	
	public String upsertEnquiry(EnquiryForm form);
	
//	List<StudentEnqEntity> getFilteredEnquiries(EnquirySearchFilter filter);
	public List<StudentEnqEntity> getFilteredEnquiries(EnquirySearchFilter filter,Integer userId);
	
	public EnquiryForm getEnquiry(Integer enqId);
	
	public List<StudentEnqEntity> getEnquries();
}