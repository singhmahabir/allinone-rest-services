/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.bl;

/**
 * @author Mahabir Singh
 *
 */
public interface IDConverter {

	String getShortURL(Integer key);

	Integer getURLId(String shortURL);
}
