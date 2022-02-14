package tt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loader.EODHistDataLoader;

@RestController
@RequestMapping("/load")
public class LoadEODHistData {

	private EODHistDataLoader dataLoader = new EODHistDataLoader();
	
	@CrossOrigin(origins = "http://localhost:4040")
	@GetMapping("/{exchange}/{symbol}")
	public void loadData(@PathVariable("exchange") String exchange, @PathVariable("symbol") String symbol) throws Exception {
		System.out.println("Loading data for - "+ symbol);
		dataLoader.loadData(exchange.toUpperCase(), symbol.toUpperCase());
	}
	
	@CrossOrigin(origins = "http://localhost:4040")
	@GetMapping("/{exchange}/{symbol}/{freq}")
	public void loadData(@PathVariable("exchange") String exchange, 
			@PathVariable("symbol") String symbol, @PathVariable("freq") String freq) throws Exception {
		System.out.println("Get Timeseries for symbol - "+ symbol + " and freq - "+ freq);
		dataLoader.loadData(exchange.toUpperCase(), symbol.toUpperCase(),freq.toLowerCase());
	}
	
}