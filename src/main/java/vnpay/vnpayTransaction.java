package vnpay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Payment;

@WebServlet(name = "vnpayTransaction", urlPatterns = {"/vnpaytransaction"})
public class vnpayTransaction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String vnp_amount = req.getParameter("vnp_Amount");
    	String vnp_BankCode = req.getParameter("vnp_BankCode");
    	String vnp_ResponseCode = req.getParameter("vnp_ResponseCode");
    	String vnp_OrderInfo = req.getParameter("vnp_OrderInfo");
    	String vnp_PayDate = req.getParameter("vnp_PayDate");
    	if(vnp_ResponseCode.equals("00")) {
    		String dateFormat = "yyyyMMddHHmmss";
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(dateFormat);
                java.util.Date utilDate = inputFormat.parse(vnp_PayDate);
                java.sql.Date sqlDate = new Date(utilDate.getTime());
                int check = 1;
                PayTransaction payTransaction = new PayTransaction();
                payTransaction.processRequest(req, resp, sqlDate, Long.parseLong(vnp_amount)/100, vnp_BankCode, check, vnp_OrderInfo);
                
            } catch (Exception e) {
            	resp.sendRedirect("/petshop/order");
			}
    	}else {
    		resp.sendRedirect("/petshop/order");
    	}
    	
    }
}