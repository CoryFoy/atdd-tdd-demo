package com.coryfoy.discounter;

import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

public class DiscountCalculatorServlet extends HttpServlet {

    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws IOException
    {
        res.setContentType("application/json");
        JsonObject responseObject = new JsonObject();

        double discountTotal;

        DiscountCalculator calculator = new DiscountCalculator();
        double orderTotal = Double.parseDouble(req.getParameter("total"));
        discountTotal = calculator.discountFor(orderTotal);


        Map<String, String> responseMap = new HashMap<String, String>();
        responseObject.addProperty("totalBeforeDiscount", orderTotal);
        responseObject.addProperty("totalDiscount", discountTotal);
        responseObject.addProperty("totalAfterDiscount", (orderTotal - discountTotal));

        PrintWriter out = res.getWriter();
        out.println(responseObject.toString());
    }
}
