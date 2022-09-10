package com.example.coronavirustracker.services;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.coronavirustracker.models.LocationStats;

@Service
public class CoronaVirusDataService {
	
	// get the data on that raw csv day.
	
	private static String VIRUS_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	// after this service starts , this method is run
	private List<LocationStats> allStats = new ArrayList<>();
	
	public List<LocationStats> getAllStats() {
		return allStats;
	}

	public void setAllStats(List<LocationStats> allStats) {
		this.allStats = allStats;
	}

	@PostConstruct
	@Scheduled(cron = "* * 1 * * *") // schedules a run of a method on a daily basis 
	// * sec  * min  * * * * -> means run every second
	public void fetchVirusData() throws IOException, InterruptedException {
		List<LocationStats> newStats = new ArrayList<>(); // why ? so when we are updating data on a day and if someone tries to access the service then it fails 
		HttpClient client  = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(VIRUS_DATA_URL))
                    .build();
		HttpResponse<String> httpResponse = client.send(request,HttpResponse.BodyHandlers.ofString());
		// System.out.println(httpResponse.body()); // text -> csv format 
		
		// need to parse so use csv library 
		// Reader in = new FileReader("path/to/file.csv");
	   StringReader csvBodyReader = new StringReader(httpResponse.body());
		@SuppressWarnings("deprecation")
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		
		for (CSVRecord record : records) {
			LocationStats locationStat = new LocationStats();
			locationStat.setState(record.get("Province/State"));
			locationStat.setCountry(record.get("Country/Region"));
		    locationStat.setLatestTotalCases(Integer.parseInt(record.get(record.size()-1)));
		    int latestDayCases = Integer.parseInt(record.get(record.size()-1));
		    int prevDayCases = Integer.parseInt(record.get(record.size()-2));
		    locationStat.setDiffFromPrevDay(latestDayCases-prevDayCases);
		   //  System.out.println(locationStat);
		    
		    newStats.add(locationStat);
		    //String state = record.get("Province/State");
		   // System.out.println(state);
		    //String customerNo = record.get("CustomerNo");
		    // String name = record.get("Name");
		}
		this.allStats = newStats;
	}

}
