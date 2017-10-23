package ru.sstu.ushankashop;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CatalogServlet extends HttpServlet{

    private static List<Item> ITEMS = Arrays.asList(new Item(0L, "Hat-Ushanka", "warm and Cozy", 99.99, 15),
            new Item(1L, "Varezhka", "Soft", 50.00, 15));

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getOutputStream().print(ITEMS.toString());
        //resp.getOutputStream().flush();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), new ItemList(ITEMS));
        /*
        try {
            //JAXBContext jaxbContext = JAXBContext.newInstance(ItemList.class);
            //Marshaller marshaller = jaxbContext.createMarshaller();
            //marshaller.marshal(new ItemList(ITEMS), resp.getOutputStream());


        }catch (Exception e){
            throw new RuntimeException(e);
        }*/


    }

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }


}
