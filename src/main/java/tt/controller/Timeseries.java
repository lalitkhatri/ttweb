package tt.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loader.ViewTimeseries;
import model.Record;

@RestController
@RequestMapping("/timeseries")
public class Timeseries {

	private ViewTimeseries viewtimeseries = new ViewTimeseries();
	
	@CrossOrigin(origins = "http://localhost:4040")
	@GetMapping("/{symbol}")
	public Map<String, Record> getTimeseries(@PathVariable("symbol") String symbol) throws Exception {
		System.out.println("Get Timeseries for - "+ symbol);
		return viewtimeseries.getTimeseries(symbol);
	}
	
	@CrossOrigin(origins = "http://localhost:4040")
	@GetMapping("/{symbol}/{freq}")
	public Map<String, Record> getTimeseries(@PathVariable("symbol") String symbol, @PathVariable String freq) throws Exception {
		System.out.println("Get Timeseries for symbol - "+ symbol + " and freq - "+ freq);
		return viewtimeseries.getTimeseries(symbol,freq);
	}

}