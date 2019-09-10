package evgenyt.cameldemo;

// Class to process messages
public class MyBean {
    // Receive message from queue and add "Camel!" to it
    public String appendCamel(String msg) {
        return msg + " Camel!";
    }
}
