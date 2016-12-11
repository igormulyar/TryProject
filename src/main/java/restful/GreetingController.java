package restful;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.DELETE)
    public Greeting decrementGreeting() {
        counter.set(counter.intValue() - 1);
        return new Greeting(counter.get(), "Bitch!");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHtml() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/igor/IdeaProjects/TryProject/src/main/java/restful/html/index.html"));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = reader.readLine();
        }
        return sb.toString();
    }

    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public List<Greeting> getGreetingList(){
        ArrayList<Greeting> list = new ArrayList<>();
        list.add(new Greeting(counter.incrementAndGet(), "the zero element"));
        list.add(new Greeting(counter.incrementAndGet(), "the first element"));
        list.add(new Greeting(counter.incrementAndGet(), "the second element"));
        list.add(new Greeting(counter.incrementAndGet(), "the third element"));
    return list;
    }

}
