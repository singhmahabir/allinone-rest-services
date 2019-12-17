/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.bl;

import org.springframework.stereotype.Service;

/**
 * @author Mahabir Singh
 *
 */
@Service
public class IDConverterService implements IDConverter {

	// Map to store 62 possible characters
	public static final String RESERVED_KEY = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Override
	public String getShortURL(Integer key) {
		final StringBuilder builder = new StringBuilder();
		while (key > 0) {
			final int reminder = key % 62;
			builder.append(RESERVED_KEY.charAt(reminder));
			key = key / 62;
		}
		return builder.reverse().toString();
	}

	@Override
	public Integer getURLId(String shortURL) {
		Integer code = 0;
		for (int i = 0; i < shortURL.length(); i++) {
			code += RESERVED_KEY.indexOf(shortURL.charAt(i)) * (int) Math.pow(62, shortURL.length() - 1 - i);
		}
		return code;
	}

}
