package evgenyt.cameldemo;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Camel Spring demo
 * Get message from queue, modify and redirect to console
 * Sep 2019 EvgenyT
 */

public class CamelSpring {
    public static void main(String[] args) {
        // App context
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // Camel context
        CamelContext camelContext = new SpringCamelContext(appContext);
        try {
            // Start context
            camelContext.start();
            // Send message to queue
            ProducerTemplate template = camelContext.createProducerTemplate();
            template.sendBody("activemq:test.queue", "Hello World");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            camelContext.stop();
        }
    }
}
