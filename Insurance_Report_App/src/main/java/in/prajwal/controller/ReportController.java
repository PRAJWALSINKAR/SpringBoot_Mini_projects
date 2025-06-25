package in.prajwal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.prajwal.request.SearchRequest;
import in.prajwal.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		SearchRequest searchObj = new SearchRequest();

		    // ✅ Log values to ensure object is not null
		    System.out.println("SearchRequest object: " + searchObj);
		    System.out.println("PlanName: " + searchObj.getPlanName());
		    System.out.println("PlanStatus: " + searchObj.getPlanStatus());
		    System.out.println("Gender: " + searchObj.getGender());

		    List<String> names = service.getPlanNames();
		    List<String> statuses = service.getPlanStatuses();

		    System.out.println("Plan Names: " + names);
		    System.out.println("Plan Statuses: " + statuses);

		    model.addAttribute("search", searchObj);
		    model.addAttribute("name", names);
		    model.addAttribute("status", statuses);

		  

		return "index";
	}
}
