package test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLTest {
	public static void main(String[] args) {
		String xml = "";
        try {
    		Map<String, List> map = new HashMap<String, List>();
    		Fruit f = new Fruit();
    		f.name="사과";
    		f.price=3000;
    		
    		Fruit f2 = new Fruit();
    		f2.name="사과";
    		f2.price=3000;
    		
    		ArrayList<Fruit> list = new ArrayList<Fruit>();
    		list.add(f);
    		list.add(f2);
    		
    		map.put("fruits", list);
            
        	
            JAXBContext jaxbContext = JAXBContext.newInstance(map.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //jaxbMarshaller.marshal(data, System.out);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(map, sw);
            xml = sw.toString();
            
            System.out.println(xml);
            
        } catch (JAXBException e) {
            //handle your exception here
        	e.printStackTrace();
        }
        
	}
}
