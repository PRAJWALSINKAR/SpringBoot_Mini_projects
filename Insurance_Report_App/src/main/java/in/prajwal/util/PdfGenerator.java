package in.prajwal.util;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.prajwal.entity.CitizenPlan;
import in.prajwal.repo.CitizenPlanRepository;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class PdfGenerator {
	
		@Autowired
		private CitizenPlanRepository planRepo;
		
		public void generate(HttpServletResponse response,List<CitizenPlan>plans,File f) throws Exception{
			Document document = new Document(PageSize.A4);
			PdfWriter pdfwriter = PdfWriter.getInstance(document,response.getOutputStream());
			PdfWriter.getInstance(document,new FileOutputStream(f));
			document.open();
			
			Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			fontTiltle.setSize(20);
			
			Paragraph paragraph = new Paragraph("Citizens Plan", fontTiltle);
		
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
			document.add(paragraph);
			Paragraph p = new Paragraph(" ");
			document.add(p);
			
			PdfPTable table = new PdfPTable(6);
			table.addCell("Id");
			table.addCell("Citizen Name");
			table.addCell("Plan Name");
			table.addCell("Plan Status");
			table.addCell("Start Date");
			table.addCell("End Date");
			
			
			
			
			for(CitizenPlan plan : plans) {
				table.addCell(String.valueOf(plan.getCitizenId()));
				table.addCell(plan.getCitizenName());
				table.addCell(plan.getPlanName());
				table.addCell(plan.getPlanStatus());
				table.addCell(plan.getPlanStartDate()+"");
				table.addCell(plan.getPlanEndDate()+"");
		}
			
			document.add(table);
			document.close();
			
		}
}