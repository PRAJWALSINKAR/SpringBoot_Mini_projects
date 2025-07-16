package in.prajwal.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import in.prajwal.entity.CitizenPlan;
import in.prajwal.repo.CitizenPlanRepository;
import in.prajwal.request.SearchRequest;
import in.prajwal.util.EmailUtils;
import in.prajwal.util.ExcelHGenerator;
import in.prajwal.util.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ServiceImpl implements ReportService {

    @Autowired
    private CitizenPlanRepository repo;

    @Autowired
    private ExcelHGenerator excelGenerator;

    @Autowired
    private PdfGenerator pdfGenerator;
    
    @Autowired
    private EmailUtils emailutils;

    @Override
    public List<String> getPlanNames() {
        return repo.getPlanNames();
    }

    @Override
    public List<String> getPlanStatuses() {
        return repo.getPlanStatus();
    }

    @Override
    public List<CitizenPlan> search(SearchRequest request) {
        CitizenPlan entity = new CitizenPlan();

        if (request.getPlanName() != null && !request.getPlanName().isEmpty()) {
            entity.setPlanName(request.getPlanName());
        }

        if (request.getPlanStatus() != null && !request.getPlanStatus().isEmpty()) {
            entity.setPlanStatus(request.getPlanStatus());
        }

        if (request.getGender() != null && !request.getGender().isEmpty()) {
            entity.setGender(request.getGender());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (request.getStartDate() != null && !request.getStartDate().isEmpty()) {
            LocalDate startDate = LocalDate.parse(request.getStartDate(), formatter);
            entity.setPlanStartDate(startDate);
        }

        if (request.getEndDate() != null && !request.getEndDate().isEmpty()) {
            LocalDate endDate = LocalDate.parse(request.getEndDate(), formatter);
            entity.setPlanEndDate(endDate);
        }

        return repo.findAll(Example.of(entity));
    }

    @Override
    public boolean exportExcel(HttpServletResponse response, SearchRequest request) throws Exception {
        File file = new File("plans.xls");

        List<CitizenPlan> filteredPlans = search(request);
        excelGenerator.generate(response, filteredPlans, file);

          String sub = "Test mail subbject";
          String body = "<h1>Test mail body<h1>";
          String to = "sinkarprajwal2003@gmail.com";
          
           
          emailutils.sendEmail(sub, body, to, file);

        file.delete();
        return true;
    }

    @Override
    public boolean exportdf(HttpServletResponse response) throws Exception {
        File file = new File("Plans.pdf");

        List<CitizenPlan> plans = repo.findAll();
        pdfGenerator.generate(response, plans, file);
       
        String sub = "Test mail subbject";
        String body = "<h1>Test mail body<h1>";
        String to = "sinkarprajwal2003@gmail.com";
        
         
        emailutils.sendEmail(sub, body, to, file);



        file.delete();
        return true;
    }
}
