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
	@GetMapping("/{exchange}/{symbol}")
	public Map<String, Record> getTimeseries(@PathVariable("exchange") String exchange, @PathVariable("symbol") String symbol) throws Exception {
		System.out.println("Get Timeseries for - "+ symbol);
		return viewtimeseries.getTimeseries(exchange.toUpperCase(), symbol.toUpperCase());
	}
	
	@CrossOrigin(origins = "http://localhost:4040")
	@GetMapping("/{exchange}/{symbol}/{freq}")
	public Map<String, Record> getTimeseries(@PathVariable("exchange") String exchange, 
			@PathVariable("symbol") String symbol, @PathVariable("freq") String freq) throws Exception {
		System.out.println("Get Timeseries for symbol - "+ symbol + " and freq - "+ freq);
		return viewtimeseries.getTimeseries(exchange.toUpperCase(), symbol.toUpperCase(),freq.toUpperCase());
	}

}