package com.resource;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Quote;
import com.repository.QuotesRepository;
import com.req.domain.Quotes;

@RestController
@RequestMapping("/rest/db")
public class DBResource {

	@Autowired
	private QuotesRepository quotesRepository; 
	
	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username){
		
		/*return quotesRepository.findByUsername(username)
									.stream()
										.map(new Function<Quote, String>() {
											@Override
											public String apply(Quote quote) {
												return quote.getQuote();
											}
										})
										.collect(Collectors.toList());*/
		
		/*return quotesRepository.findByUsername(username)
								.stream()
									.map(quote -> quote.getQuote())
									.collect(Collectors.toList());*/
		/*return quotesRepository.findByUsername(username)
								.stream()
									.map(Quote::getQuote)
									.collect(Collectors.toList());*/
		
		return getQuotesByUsername(username);
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes){
		
		quotes.getQuotes().stream()
				.forEach(new Consumer<String>() {
					@Override
					public void accept(String quote) {
						quotesRepository.save(new Quote(quotes.getUsername(), quote));
					}
				});
		
		return getQuotesByUsername(quotes.getUsername());
	}
	
	private List<String> getQuotesByUsername(String username){
		return quotesRepository.findByUsername(username)
								.stream()
									.map(new Function<Quote, String>() {
										@Override
										public String apply(Quote quote) {
											return quote.getQuote();
										}
									})
									.collect(Collectors.toList());
	}
	
	@DeleteMapping("/delete/{username}")
	public List<String> deleteByUsername(@PathVariable("username")final String username) {
		quotesRepository.deleteByUsername(username);
		
		return getQuotesByUsername(username);
	}
}
