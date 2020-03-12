/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.controller.impl;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import singh.mahabir.service.IDConverter;

/**
 * @author Mahabir Singh
 *
 */

@RestController
public class URLshortenerImpl {

	@Autowired
	private IDConverter converter;

//	@Autowired
//	private URLshortenerRepository repository;

	@GetMapping(value = "encoder", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> encoder(@NotEmpty Integer key) {

//		final URLshortener data = new URLshortener();
//		data.setUrl(key);
//		final URLshortener newdata = repository.save(data);

		final String encodesKey = converter.getShortURL(key);
		return ResponseEntity.ok(encodesKey);
	}

	@GetMapping(value = "decoder")
	public Integer decoder(@NotEmpty String url) {
		final int key = converter.getURLId(url);
//		final Optional<URLshortener> findById = repository.findById(key);

		return key;

	}

}
