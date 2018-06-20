package cn.artisan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {
	
    @RequestMapping("/hello")
    String home() {
	return "hello world!";
    }
    
    @RequestMapping("/tokenverify")
    public void getWxResult(HttpServletRequest req, HttpServletResponse res) {
	String TOKEN = "Artisan998";	
    	Logger logger= Logger.getLogger(SpringBootWebApplication.class);
    	String signature = req.getParameter("signature"); 
	String timestamp = req.getParameter("timestamp");
	String nonce = req.getParameter("nonce");
	String echostr = req.getParameter("echostr");
	PrintWriter out = null;
	//return echostr;
	String[] str = { TOKEN, timestamp, nonce };
	Arrays.sort(str);
	String bigStr = str[0] + str[1] + str[2];
	String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
	logger.info("siganature is :" + signature);
	logger.info("after sh1 string is: " + digest);
	if (digest.equals(signature)){
        try {  
            out = res.getWriter();  
            out.print(echostr);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            out.close();  
            out = null;  
        }  
	}
	
    }    
}
