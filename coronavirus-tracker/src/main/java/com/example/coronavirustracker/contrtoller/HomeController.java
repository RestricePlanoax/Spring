package com.example.coronavirustracker.contrtoller;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coronavirustracker.models.LocationStats;
import com.example.coronavirustracker.services.CoronaVirusDataService;

@Controller
public class HomeController {
	// autowire service into controller 
	   @Autowired
	   CoronaVirusDataService coronaVirusDataService;
	   
	   @GetMapping("/")
       public String home(Model model) {
		   // put data in a model and this will be 
		   // this is will accessible in html
		   List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		   int totalReportedCases = allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
		   int totalNewCases = allStats.stream().mapToInt(stat->stat.getDiffFromPrevDay()).sum();
		   model.addAttribute("locationStats",allStats);
		   model.addAttribute("totalReportedCases", totalReportedCases);
		   model.addAttribute("totalNewCases",totalNewCases);
		   //UI concern.. we need controller reason
		   
    	   return "home";
       }
       // returns a json respone .. so rest api response ..
       
}
