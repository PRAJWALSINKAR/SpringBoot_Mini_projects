package in.prajwal.service; 

import java.util.Collection;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.prajwal.binding.DashBoardResponse;
import in.prajwal.binding.EnquiryForm;
import in.prajwal.binding.EnquirySearchFilter;
import in.prajwal.entity.CourseEntity;
import in.prajwal.entity.EnqStatusEntity;
import in.prajwal.entity.StudentEnqEntity;
import in.prajwal.entity.UserDtlsEntity;
import in.prajwal.repo.CourseRepo;
import in.prajwal.repo.EnqStatusRepo;
import in.prajwal.repo.StudentEnqRepo;
import in.prajwal.repo.UserDtlsRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private EnqStatusRepo statusRepo;
	
	@Autowired
	private UserDtlsRepo userDtlsRepo;
	@Autowired
	private HttpSession session;
	
	
	@Autowired
	private StudentEnqRepo studentEnqRepo;
	
	@Override
	public List<StudentEnqEntity> getEnquries(){
		Integer userId =  (Integer)session.getAttribute("userId");
		Optional<UserDtlsEntity> findbyId = userDtlsRepo.findById(userId);
		if(findbyId.isPresent()) {
			UserDtlsEntity userDtlsEntity =  findbyId.get();
			List<StudentEnqEntity> enquiries = userDtlsEntity.getEnquiries();
			return enquiries;
		}
		return null;
	}

	@Override
	public List<String> getCourseName() {
	    return courseRepo.findAll()
	                     .stream()
	                     .map(CourseEntity::getCourseName)
	                     .collect(Collectors.toList());
	}

	@Override
	public List<String> getEnqStatus() {
	    return statusRepo.findAll()
	                     .stream()
	                     .map(EnqStatusEntity::getStatusName)
	                     .collect(Collectors.toList());
	}

	@Override
	public DashBoardResponse getDashboardData(Integer userId) {
		// TODO Auto-generated method stub
		DashBoardResponse response = new DashBoardResponse();

		Optional<UserDtlsEntity> findById = userDtlsRepo.findById(userId);

		if (findById.isPresent()) {
		    UserDtlsEntity userEntity = findById.get();

		    List<StudentEnqEntity> enquiries = userEntity.getEnquiries();
            // total enq
		    Integer totalCnt = enquiries.size();
		                       
		    Integer enrolledCnt = enquiries.stream()
		    	    .filter(e -> e.getEnqStatus().equals("Enrolled"))
		    	    .collect(Collectors.toList()).size();

		    	Integer lostCnt = enquiries.stream()
		    	    .filter(e -> e.getEnqStatus().equals("Lost"))
		    	    .collect(Collectors.toList()).size();

		    	response.setTotalEnquriesCnt(totalCnt);
		    	response.setEnrolledCnt(enrolledCnt);
		    	response.setLostCnt(lostCnt);

		}

		return response;
	}


    //saving the query
	@Override
	public String upsertEnquiry(EnquiryForm form) {
	    Integer userId = (Integer) session.getAttribute("userId");
	    Optional<UserDtlsEntity> userOpt = userDtlsRepo.findById(userId);

	    if (userOpt.isPresent()) {
	        StudentEnqEntity enq;

	        // 🟡 If editing (enqId is present), fetch existing entity
	        if (form.getEnqId() != null) {
	            Optional<StudentEnqEntity> opt = studentEnqRepo.findById(form.getEnqId());
	            enq = opt.orElse(new StudentEnqEntity()); // fallback to new if not found
	        } else {
	            enq = new StudentEnqEntity(); // 🟢 New insert
	        }

	        // Set data (common for insert or update)
	        enq.setStudentName(form.getStudentName());
	        enq.setStudentPhno(form.getStudentPhno());
	        enq.setCourseName(form.getCourseName());
	        enq.setClassMode(form.getMode());
	        enq.setEnqStatus(form.getEnqStatus());
	        enq.setUser(userOpt.get());

	        studentEnqRepo.save(enq); // ✅ Save or update

	        return "success";
	    }

	    return "fail";
	}
	
	@Override
	public List<StudentEnqEntity> getFilteredEnquiries(EnquirySearchFilter filter, Integer userId) {
	    Optional<UserDtlsEntity> findById = userDtlsRepo.findById(userId);
	    if (findById.isPresent()) {
	        UserDtlsEntity user = findById.get();
	        List<StudentEnqEntity> enquiries = user.getEnquiries();

	        if (filter.getCourseName() != null && !filter.getCourseName().isEmpty()) {
	            enquiries = enquiries.stream()
	                .filter(e -> e.getCourseName().equals(filter.getCourseName()))
	                .collect(Collectors.toList());
	        }

	        if (filter.getEnqStatus() != null && !filter.getEnqStatus().isEmpty()) {
	            enquiries = enquiries.stream()
	                .filter(e -> e.getEnqStatus().equals(filter.getEnqStatus()))
	                .collect(Collectors.toList());
	        }

	        if (filter.getClassMode() != null && !filter.getClassMode().isEmpty()) {
	            enquiries = enquiries.stream()
	                .filter(e -> e.getClassMode().equals(filter.getClassMode()))
	                .collect(Collectors.toList());
	        }

	        return enquiries;
	    }

	    return List.of(); // return empty list if user not found
	}

	
//	@Override
//	public List<StudentEnqEntity> getFilteredEnquiries(EnquirySearchFilter filter) {
//	    Integer userId = (Integer) session.getAttribute("userId");
//	    Optional<UserDtlsEntity> userOpt = userDtlsRepo.findById(userId);
//
//	    if (userOpt.isPresent()) {
//	        List<StudentEnqEntity> enquiries = userOpt.get().getEnquiries();
//
//	        // In-memory filtering (for simplicity — use JPA Query for efficiency in real projects)
//	        return enquiries.stream()
//	                .filter(e -> filter.getCourseName() == null || filter.getCourseName().isEmpty() || e.getCourseName().equals(filter.getCourseName()))
//	                .filter(e -> filter.getEnqStatus() == null || filter.getEnqStatus().isEmpty() || e.getEnqStatus().equals(filter.getEnqStatus()))
//	                .filter(e -> filter.getClassMode() == null || filter.getClassMode().isEmpty() || e.getClassMode().equals(filter.getClassMode()))
//	                .toList();
//	    }
//
//	    return List.of(); // empty list
//	}




	@Override
	public EnquiryForm getEnquiry(Integer enqId) {
	
	    Optional<StudentEnqEntity> opt = studentEnqRepo.findById(enqId);
	    
	    if (opt.isPresent()) {
	        StudentEnqEntity entity = opt.get();
	        EnquiryForm form = new EnquiryForm();

	        form.setEnqId(entity.getEnqId()); // make sure this field exists in your form
	        form.setStudentName(entity.getStudentName());
	        form.setStudentPhno(entity.getStudentPhno());
	        form.setCourseName(entity.getCourseName());
	        form.setMode(entity.getClassMode());
	        form.setEnqStatus(entity.getEnqStatus());

	        return form;
	    }

	    return new EnquiryForm(); // fallback empty form
	}

	
}
