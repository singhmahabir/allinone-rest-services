/**
 *
 */
package singh.mahabir.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * If you want to read a map entry in java then we need
 * MapConfigurationProperties to read
 * 
 * @author Mahabir Singh
 *
 */

@Component
//@EnableConfigurationProperties
@ConfigurationProperties(prefix = "")
// setter getter is required 
@Setter
@Getter
public class MapConfigurationProperties {

    private Map<String, String> mapofvalues = new HashMap<>();

    private Map<String, String> info = new HashMap<>();

    @PostConstruct
    public void init() {
	System.out.println("\n map " + mapofvalues);
	System.out.println("\n info " + info);
    }
}
