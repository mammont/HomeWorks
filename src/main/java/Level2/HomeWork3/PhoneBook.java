package Level2.HomeWork3;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private Map<String, HashSet<String>> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    void add (String name, String number) {
        HashSet<String> phoneNumbers;
        if (map.containsKey(name)) phoneNumbers = map.get(name);
        else phoneNumbers = new HashSet<>();
        phoneNumbers.add(number);
        map.put(name, phoneNumbers);
    }

    Set<String> get(String name) {
        System.out.print(name + ": ");
        return map.get(name);
    }
}
