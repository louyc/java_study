  
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;  
  
/** 
 * @author 马弦 
 * @date 2017年10月23日 下午2:49 
 * HttpClient工具类 
 */  
public class Test {  
      
    private static Logger logger = Logger.getLogger(Test.class);  
  
    public static void main(String[] args) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("ScriptManager1", "ScriptManager1|btnSearch");
//    	map.put("HiddenID", "");
    	map.put("ddlHomeAddress$ddlCounty", "34180201");
//    	map.put("ddlHomeAddress$ddlTownship", "");
//    	map.put("ddlHomeAddress$ddlVillage", "");
//    	map.put("ddlHomeAddress$ddlGroup", "");
    	map.put("cblZDRQ$0", "0");
    	map.put("cblZDRQ$1", "3");
    	map.put("cblZDRQ$2", "4");
    	map.put("cblZDRQ$3", "5");
    	map.put("cblZDRQ$4", "6");
    	map.put("cblZDRQ$5", "1");
    	map.put("cblZDRQ$6", "2");
    	map.put("cblZDRQ$0", "0");
    	map.put("cblZDRQ$0", "0");
    	map.put("ddlWriteOff", "false");
//    	map.put("txtName", "");
//    	map.put("txtIdCardNo", "");
//    	map.put("txtFileNum", "");
//    	map.put("txtHealthCardNo", "");
//    	map.put("txtStarAge", "");
//    	map.put("txtEndAge", "");
    	map.put("txtCheckTime1", "2018-01-01");
    	map.put("txtCheckTime2", "2018-12-31");
//    	map.put("ddlYearCheck", "");
    	map.put("ddlDoctor", "全部");
//    	map.put("txtFileDate1", "");
//    	map.put("txtFileDate2", "");
//    	map.put("ddlHosp", "");
    	map.put("ddlMine0", "1");
//    	map.put("ddlAdminRegion", "");
    	map.put("iccardno1", "1");
//    	map.put("__EVENTTARGET","" );
//    	map.put("__EVENTARGUMENT", "");
//    	map.put("__LASTFOCUS","" );
    	map.put("__VIEWSTATE","/wEPDwUKMjA3NzI0MjUzNg9kFgICAQ9kFgYCBQ9kFgJmD2QWCgIBD2QWAmYPZBYCZg9kFggCAQ8QDxYGHg1EYXRhVGV4dEZpZWxkBQp"
    			+ "SZWdpb25OYW1lHg5EYXRhVmFsdWVGaWVsZAUKUmVnaW9uQ29kZR4LXyFEYXRhQm91bmRnZBAVAQzopb/mnpfooZfpgZMVAQgzNDE4MDIwMRQrAw"
    			+ "FnFgFmZAIDDxAPFgYfAAUKUmVnaW9uTmFtZR8BBQpSZWdpb25Db2RlHwJnZBAVBQ0tLeacqumAieaLqS0tD+Wfjuilv+WxheWnlOS8mg/opb/m"
    			+ "npflsYXlp5TkvJoP5pit5Lqt5bGF5aeU5LyaD+S5neWQjOWxheWnlOS8mhUFAAozNDE4MDIwMTAxCjM0MTgwMjAxMDIKMzQxODAyMDEwMwozN"
    			+ "DE4MDIwMTA0FCsDBWdnZ2dnFgFmZAIFDxBkEBUBDS0t5pyq6YCJ5oupLS0VAQAUKwMBZxYBZmQCBw8QZBAVAQ0tLeacqumAieaLqS0tFQEAF"
    			+ "CsDAWdkZAIDDxBkZBYBZmQCHQ8QZA8WfWYCAQICAgMCBAIFAgYCBwIIAgkCCgILAgwCDQIOAg8CEAIRAhICEwIUAhUCFgIXAhgCGQIaAhsCHAI"
    			+ "dAh4CHwIgAiECIgIjAiQCJQImAicCKAIpAioCKwIsAi0CLgIvAjACMQIyAjMCNAI1AjYCNwI4AjkCOgI7AjwCPQI+Aj8CQAJBAkICQwJEAkUCR"
    			+ "gJHAkgCSQJKAksCTAJNAk4CTwJQAlECUgJTAlQCVQJWAlcCWAJZAloCWwJcAl0CXgJfAmACYQJiAmMCZAJlAmYCZwJoAmkCagJrAmwCbQJuAm"
    			+ "8CcAJxAnICcwJ0AnUCdgJ3AngCeQJ6AnsCfBZ9EAUKLS3lhajpg6gtLQUG5YWo6YOoZxBlZWcQBQcg6ZmI5YekBQcg6ZmI5YekZxAFByDmiL/"
    			+ "mnpcFByDmiL/mnpdnEAUKIOiDoeWul+WlhwUKIOiDoeWul+Wlh2cQBQog6bKB56aP6IuxBQog6bKB56aP6IuxZxAFByDmnajlqbcFByDmnajl"
    			+ "qbdnEAUKIOW8oOe+iuWFsAUKIOW8oOe+iuWFsGcQBQJ6bAUCemxnEAUH6ZmIIOWHpAUH6ZmIIOWHpGcQBQbpmYjlh6QFBumZiOWHpGcQBQbpmY"
    			+ "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"
    			+ "mraNnEAUJ5pyx5rC46JCNBQnmnLHmsLjokI1nZGQCIw8QZA8WBmYCAQICAgMCBAIFFgYQBQotLeWFqOmDqC0tZWcQBRvmsoHlm63npL7ljLrlja"
    			+ "vnlJ/mnI3liqHnq5kFCjM0MTgwMjAzMDFnEAUe5pWs5Lqt6IuR56S+5Yy65Y2r55Sf5pyN5Yqh56uZBQozNDE4MDIwMzAyZxAFG+Wfjuilv+ekv"
    			+ "uWMuuWNq+eUn+acjeWKoeermQUKMzQxODAyMDMwNGcQBRvkuZ3lkIznpL7ljLrljavnlJ/mnI3liqHnq5kFCjM0MTgwMjAzMDNnEAUt5a6j5bee"
    			+ "5Yy66KW/5p6X6KGX6YGT56S+5Yy65Y2r55Sf5pyN5Yqh5Lit5b+DBQkzNDE4MDIwMzBnZGQCJw8QZBAVAQotLeWFqOmDqC0tFQEAFCsDAWdkZAI"
    			+ "HDw9kFgIeB29uY2xpY2sFF3JldHVybiBDbGVhckhpZGRlbklEKCk7ZAIXD2QWAmYPZBYEAgEPDxYEHgpfcGFnZUluZGV4AgEeDF9yZWNvcmRDb3"
    			+ "VudAKG8QFkFgpmDw8WAh4EVGV4dAU45pys5qyh5p+l6K+i57uT5p6c5YWxIDMwODU0IOadoS4g5b2T5YmN56ysIDEgLyAyMDU3IOmhtS5kZAIBDw"
    			+ "8WAh4HVmlzaWJsZWhkZAICDw8WAh8HaGRkAgQPDxYCHwdnZGQCBQ8PFgIfB2dkZAIDDzwrABEDAA8WBB8CZx4LXyFJdGVtQ291bnQCD2QBEBYAFg"
    			+ "AWAAwUKwAAFgJmD2QWIAIBDw9kFggfAwUjV2VpS2FuZ0dyaWRWaWV3MV9zcih0aGlzLCcyMDI4MjQ5JykeBXN0eWxlBQ9jdXJzb3I6ZGVmYXVsdD"
    			+ "seC29ubW91c2VvdmVyBRxXZWlLYW5nR3JpZFZpZXcxX21vdmVyKHRoaXMpHgpvbm1vdXNlb3V0BRtXZWlLYW5nR3JpZFZpZXcxX21vdXQodGhpc"
    			+ "ykWKGYPZBYCAgEPFgIeBXZhbHVlBQcyMDI4MjQ5ZAIBDw8WAh8GBQnotbXnv7DmoZBkZAICD2QWAmYPFQED55S3ZAIDDw8WAh8GBQYmbmJzcDtk"
    			+ "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"
    			+ "mJzcDtkZAIEDw8WAh8GBREzNDE4MDIwMDEwMDQwNjA1MmRkAgUPDxYCHwYFEjM0MjUyMzE5NjcwMzEyMzEyeGRkAgYPDxYCHwYFLeWuo+WfjuW4guWuo+W3nuWMuuilv+ael+ihl+mBk+S5neWQjOWxheWnlOS8mmRkAgcPDxYCHwYFCzE1OTU2Mzg4NzM5ZGQCCA9kFgJmDxAPFgQfBmUfDWhkZGRkAgkPDxYCHwYFCemygeemj+iLsWRkAgoPZBYCZg8VAS3lrqPlt57ljLropb/mnpfooZfpgZPnpL7ljLrljavnlJ/mnI3liqHkuK3lv4NkAgsPZBYCZg8VAS3lrqPlt57ljLropb/mnpfooZfpgZPnpL7ljLrljavnlJ/mnI3liqHkuK3lv4NkAgwPZBYCZg8VAQBkAg0PDxYCHwYFCDIwMTguNC43ZGQCDg8PFgIfBgUGeHp4bHNxZGQCDw8PFgIfBgUPMTgtNC03IDE2OjE1OjU2ZGQCEA8PFgIfBgUGJm5ic3A7ZGQCEQ9kFgJmDxUBBzIwMjc5MzdkAhIPZBYCZg8VAQcyMDI3OTM3ZAITD2QWAmYPFQEHMjAyNzkzN2QCEA8PFgIfB2hkZBgCBR5fX0NvbnRyb2xzUmVxdWlyZVBvc3RCYWNrS2V5X18WHQUHY2J4TWluZQUJY2JsWkRSUSQwBQljYmxaRFJRJDEFCWNibFpEUlEkMgUJY2JsWkRSUSQzBQljYmxaRFJRJDQFCWNibFpEUlEkNQUJY2JsWkRSUSQ2BQljYmxaRFJRJDYFCWJ0blNlYXJjaAUoU2VhcmNoWE5ISUNDYXJkTm9Db250cm9sMSRidG5HZXRJQ0NhcmRObwUJQnRuSWRDYXJkBRdQYWdlQ29udHJvbDEkTmV4dEJ1dHRvbgUXUGFnZUNvbnRyb2wxJExhc3RCdXR0b24FIldlaUthbmdHcmlkVmlldzEkY3RsMDIkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDMkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDQkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDUkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDYkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDckQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDgkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDkkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTAkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTEkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3R"
    			+ "sMTIkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTMkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTQkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTUkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTYkQ2hlY2tTZWxlY3QFEFdlaUthbmdHcmlkVmlldzEPPCsADAEIAgFk5pfxBJ98+ymPZogMXlLermfLzSSQCGRNyjG2XwAvALw=" );
    	map.put("__VIEWSTATEGENERATOR","178BD206" );
    	map.put("__EVENTVALIDATION","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" );
    	map.put("__ASYNCPOST", "true");
    	map.put("btnSearch.x", "42");
    	map.put("btnSearch.y", "43");
    	doPost("http://xcgw.zwyc.net:82/archivesmanagement/personmanage.aspx",map);	
	}
    /** 
     * get请求 
     * @return 
     */  
    public static String doGet(String url) {  
        try {  
            HttpClient client = new DefaultHttpClient();  
            //发送get请求  
            HttpGet request = new HttpGet(url);  
            HttpResponse response = client.execute(request);  
   
            /**请求发送成功，并得到响应**/  
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {  
                /**读取服务器返回过来的json字符串数据**/  
                String strResult = EntityUtils.toString(response.getEntity());  
                  
                return strResult;  
            }  
        }   
        catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        return null;  
    }  
      
    /** 
     * post请求(用于key-value格式的参数) 
     * @param url 
     * @param params 
     * @return 
     */  
	public static String doPost(String url, Map params){  
          
        
        try {    
            // 定义HttpClient    
            HttpClient client = HttpClients.createDefault();    
            // 实例化HTTP方法    
            HttpPost request = new HttpPost();    
            request.setURI(new URI(url));  
              

          //设置参数    
//            List<NameValuePair> list = new ArrayList<NameValuePair>();    
//            Iterator iterator = params.entrySet().iterator();    
//            while(iterator.hasNext()){    
//                Entry<String,String> elem = (Entry<String, String>) iterator.next();    
//                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));    
//            }    
//            if(list.size() > 0){    
//                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");    
//                request.setEntity(entity);    
//            }  
            
//            String bodyStr = JSON.toJSONString(params);
//            StringEntity se = new StringEntity(bodyStr, Charset.forName("UTF-8"));
//            se.setContentEncoding("UTF-8");
//            request.setEntity(se);
            
            MultipartEntityBuilder reqEntity = MultipartEntityBuilder.create();;
            reqEntity.addTextBody("ScriptManager1", "ScriptManager1|btnSearch");
//        	reqEntity.addTextBody("HiddenID", "");
        	reqEntity.addTextBody("ddlHomeAddress$ddlCounty", "34180201");
//        	reqEntity.addTextBody("ddlHomeAddress$ddlTownship", "");
//        	reqEntity.addTextBody("ddlHomeAddress$ddlVillage", "");
//        	reqEntity.addTextBody("ddlHomeAddress$ddlGroup", "");
        	reqEntity.addTextBody("cblZDRQ$0", "0");
        	reqEntity.addTextBody("cblZDRQ$1", "3");
        	reqEntity.addTextBody("cblZDRQ$2", "4");
        	reqEntity.addTextBody("cblZDRQ$3", "5");
        	reqEntity.addTextBody("cblZDRQ$4", "6");
        	reqEntity.addTextBody("cblZDRQ$5", "1");
        	reqEntity.addTextBody("cblZDRQ$6", "2");
        	reqEntity.addTextBody("ddlWriteOff", "false");
//        	reqEntity.addTextBody("txtName", "");
//        	reqEntity.addTextBody("txtIdCardNo", "");
//        	reqEntity.addTextBody("txtFileNum", "");
//        	reqEntity.addTextBody("txtHealthCardNo", "");
//        	reqEntity.addTextBody("txtStarAge", "");
//        	reqEntity.addTextBody("txtEndAge", "");
        	reqEntity.addTextBody("txtCheckTime1", "2017-01-01");
        	reqEntity.addTextBody("txtCheckTime2", "2018-12-31");
//        	reqEntity.addTextBody("ddlYearCheck", "");
        	reqEntity.addTextBody("ddlDoctor", "全部");
//        	reqEntity.addTextBody("txtFileDate1", "");
//        	reqEntity.addTextBody("txtFileDate2", "");
//        	reqEntity.addTextBody("ddlHosp", "");
        	reqEntity.addTextBody("ddlMine0", "1");
//        	reqEntity.addTextBody("ddlAdminRegion", "");
//        	reqEntity.addTextBody("iccardno1", "");
//        	reqEntity.addTextBody("__EVENTTARGET","" );
//        	reqEntity.addTextBody("__EVENTARGUMENT", "");
//        	reqEntity.addTextBody("__LASTFOCUS","" );
        	reqEntity.addTextBody("__VIEWSTATE","/wEPDwUKMjA3NzI0MjUzNg9kFgICAQ9kFgYCBQ9kFgJmD2QWCgIBD2QWAmYPZBYCZg9kFggCAQ8QDxYGHg1EYXRhVGV4dEZpZWxkBQp"
        			+ "SZWdpb25OYW1lHg5EYXRhVmFsdWVGaWVsZAUKUmVnaW9uQ29kZR4LXyFEYXRhQm91bmRnZBAVAQzopb/mnpfooZfpgZMVAQgzNDE4MDIwMRQrAw"
        			+ "FnFgFmZAIDDxAPFgYfAAUKUmVnaW9uTmFtZR8BBQpSZWdpb25Db2RlHwJnZBAVBQ0tLeacqumAieaLqS0tD+Wfjuilv+WxheWnlOS8mg/opb/m"
        			+ "npflsYXlp5TkvJoP5pit5Lqt5bGF5aeU5LyaD+S5neWQjOWxheWnlOS8mhUFAAozNDE4MDIwMTAxCjM0MTgwMjAxMDIKMzQxODAyMDEwMwozN"
        			+ "DE4MDIwMTA0FCsDBWdnZ2dnFgFmZAIFDxBkEBUBDS0t5pyq6YCJ5oupLS0VAQAUKwMBZxYBZmQCBw8QZBAVAQ0tLeacqumAieaLqS0tFQEAF"
        			+ "CsDAWdkZAIDDxBkZBYBZmQCHQ8QZA8WfWYCAQICAgMCBAIFAgYCBwIIAgkCCgILAgwCDQIOAg8CEAIRAhICEwIUAhUCFgIXAhgCGQIaAhsCHAI"
        			+ "dAh4CHwIgAiECIgIjAiQCJQImAicCKAIpAioCKwIsAi0CLgIvAjACMQIyAjMCNAI1AjYCNwI4AjkCOgI7AjwCPQI+Aj8CQAJBAkICQwJEAkUCR"
        			+ "gJHAkgCSQJKAksCTAJNAk4CTwJQAlECUgJTAlQCVQJWAlcCWAJZAloCWwJcAl0CXgJfAmACYQJiAmMCZAJlAmYCZwJoAmkCagJrAmwCbQJuAm"
        			+ "8CcAJxAnICcwJ0AnUCdgJ3AngCeQJ6AnsCfBZ9EAUKLS3lhajpg6gtLQUG5YWo6YOoZxBlZWcQBQcg6ZmI5YekBQcg6ZmI5YekZxAFByDmiL/"
        			+ "mnpcFByDmiL/mnpdnEAUKIOiDoeWul+WlhwUKIOiDoeWul+Wlh2cQBQog6bKB56aP6IuxBQog6bKB56aP6IuxZxAFByDmnajlqbcFByDmnajl"
        			+ "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"
        			+ "5ZGo5b635ZOBBQnlkajlvrflk4FnEAUJ5ZGo6Iqz5YuHBQnlkajoirPli4dnEAUJ5ZGo6Z2Z6IqdBQnlkajpnZnoip1nEAUG5ZGo5q2jBQblkaj"
        			+ "mraNnEAUJ5pyx5rC46JCNBQnmnLHmsLjokI1nZGQCIw8QZA8WBmYCAQICAgMCBAIFFgYQBQotLeWFqOmDqC0tZWcQBRvmsoHlm63npL7ljLrlja"
        			+ "vnlJ/mnI3liqHnq5kFCjM0MTgwMjAzMDFnEAUe5pWs5Lqt6IuR56S+5Yy65Y2r55Sf5pyN5Yqh56uZBQozNDE4MDIwMzAyZxAFG+Wfjuilv+ekv"
        			+ "uWMuuWNq+eUn+acjeWKoeermQUKMzQxODAyMDMwNGcQBRvkuZ3lkIznpL7ljLrljavnlJ/mnI3liqHnq5kFCjM0MTgwMjAzMDNnEAUt5a6j5bee"
        			+ "5Yy66KW/5p6X6KGX6YGT56S+5Yy65Y2r55Sf5pyN5Yqh5Lit5b+DBQkzNDE4MDIwMzBnZGQCJw8QZBAVAQotLeWFqOmDqC0tFQEAFCsDAWdkZAI"
        			+ "HDw9kFgIeB29uY2xpY2sFF3JldHVybiBDbGVhckhpZGRlbklEKCk7ZAIXD2QWAmYPZBYEAgEPDxYEHgpfcGFnZUluZGV4AgEeDF9yZWNvcmRDb3"
        			+ "VudAKG8QFkFgpmDw8WAh4EVGV4dAU45pys5qyh5p+l6K+i57uT5p6c5YWxIDMwODU0IOadoS4g5b2T5YmN56ysIDEgLyAyMDU3IOmhtS5kZAIBDw"
        			+ "8WAh4HVmlzaWJsZWhkZAICDw8WAh8HaGRkAgQPDxYCHwdnZGQCBQ8PFgIfB2dkZAIDDzwrABEDAA8WBB8CZx4LXyFJdGVtQ291bnQCD2QBEBYAFg"
        			+ "AWAAwUKwAAFgJmD2QWIAIBDw9kFggfAwUjV2VpS2FuZ0dyaWRWaWV3MV9zcih0aGlzLCcyMDI4MjQ5JykeBXN0eWxlBQ9jdXJzb3I6ZGVmYXVsdD"
        			+ "seC29ubW91c2VvdmVyBRxXZWlLYW5nR3JpZFZpZXcxX21vdmVyKHRoaXMpHgpvbm1vdXNlb3V0BRtXZWlLYW5nR3JpZFZpZXcxX21vdXQodGhpc"
        			+ "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"
        			+ "mJzcDtkZAIEDw8WAh8GBREzNDE4MDIwMDEwMDQwNjA1MmRkAgUPDxYCHwYFEjM0MjUyMzE5NjcwMzEyMzEyeGRkAgYPDxYCHwYFLeWuo+WfjuW4guWuo+W3nuWMuuilv+ael+ihl+mBk+S5neWQjOWxheWnlOS8mmRkAgcPDxYCHwYFCzE1OTU2Mzg4NzM5ZGQCCA9kFgJmDxAPFgQfBmUfDWhkZGRkAgkPDxYCHwYFCemygeemj+iLsWRkAgoPZBYCZg8VAS3lrqPlt57ljLropb/mnpfooZfpgZPnpL7ljLrljavnlJ/mnI3liqHkuK3lv4NkAgsPZBYCZg8VAS3lrqPlt57ljLropb/mnpfooZfpgZPnpL7ljLrljavnlJ/mnI3liqHkuK3lv4NkAgwPZBYCZg8VAQBkAg0PDxYCHwYFCDIwMTguNC43ZGQCDg8PFgIfBgUGeHp4bHNxZGQCDw8PFgIfBgUPMTgtNC03IDE2OjE1OjU2ZGQCEA8PFgIfBgUGJm5ic3A7ZGQCEQ9kFgJmDxUBBzIwMjc5MzdkAhIPZBYCZg8VAQcyMDI3OTM3ZAITD2QWAmYPFQEHMjAyNzkzN2QCEA8PFgIfB2hkZBgCBR5fX0NvbnRyb2xzUmVxdWlyZVBvc3RCYWNrS2V5X18WHQUHY2J4TWluZQUJY2JsWkRSUSQwBQljYmxaRFJRJDEFCWNibFpEUlEkMgUJY2JsWkRSUSQzBQljYmxaRFJRJDQFCWNibFpEUlEkNQUJY2JsWkRSUSQ2BQljYmxaRFJRJDYFCWJ0blNlYXJjaAUoU2VhcmNoWE5ISUNDYXJkTm9Db250cm9sMSRidG5HZXRJQ0NhcmRObwUJQnRuSWRDYXJkBRdQYWdlQ29udHJvbDEkTmV4dEJ1dHRvbgUXUGFnZUNvbnRyb2wxJExhc3RCdXR0b24FIldlaUthbmdHcmlkVmlldzEkY3RsMDIkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDMkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDQkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDUkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDYkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDckQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDgkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMDkkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTAkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTEkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3R"
        			+ "sMTIkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTMkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTQkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTUkQ2hlY2tTZWxlY3QFIldlaUthbmdHcmlkVmlldzEkY3RsMTYkQ2hlY2tTZWxlY3QFEFdlaUthbmdHcmlkVmlldzEPPCsADAEIAgFk5pfxBJ98+ymPZogMXlLermfLzSSQCGRNyjG2XwAvALw=" );
        	reqEntity.addTextBody("__VIEWSTATEGENERATOR","178BD206" );
        	reqEntity.addTextBody("__EVENTVALIDATION","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" );
        	reqEntity.addTextBody("__ASYNCPOST", "true");
        	reqEntity.addTextBody("btnSearch.x", "33");
        	reqEntity.addTextBody("btnSearch.y", "53");
//            request.setEntity(reqEntity.build());
            
        	
        	String www_url = "ScriptManager1=ScriptManager1|btnSearch&"+
        			"ddlHomeAddress$ddlCounty=34180201&"+
        			"cblZDRQ$0=0&"+
        			"cblZDRQ$1=3&"+
        			"cblZDRQ$2=4&"+
        			"cblZDRQ$3=5&"+
        			"cblZDRQ$4=6&"+
        			"cblZDRQ$5=1&"+
        			"cblZDRQ$6=2&"+
        			"ddlWriteOff=false&"+
        			"txtCheckTime1=2017-01-01&"+
        			"txtCheckTime2=2018-11-01&"+
        			"ddlDoctor=全部&"+
        			"ddlMine0=1&"+
        			"__VIEWSTATE=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&"+
        			"__VIEWSTATEGENERATOR=178BD206&"+
        			"__EVENTVALIDATION=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&"+
        			"__ASYNCPOST=true&"+
        			"btnSearch.x=33&"+
        			"btnSearch.y=43";
            StringEntity postEntity = new StringEntity(params.toString(),
                    ContentType.create("application/x-www-form-urlencoded","utf-8"));
            request.setEntity(postEntity);
            
            request.setHeader("Accept", "*/*"); 
            request.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6"); 
            request.setHeader("Cache-Control", "no-cache"); 
//            request.setHeader("Content-Length", ""+reqEntity.build().getContentLength()); 
            request.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); 
            request.setHeader("Cookie", "ASP.NET_SessionId=2mzyovhgb5rricenfcx20j2a"); 
            request.setHeader("Host", "xcgw.zwyc.net:82"); 
            request.setHeader("Origin", "http://xcgw.zwyc.net:82"); 
            request.setHeader("Proxy-Connection", "keep-alive"); 
            request.setHeader("Referer", "http://xcgw.zwyc.net:82/archivesmanagement/personmanage.aspx"); 
            request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87Safari/537.36"); 
            request.setHeader("X-MicrosoftAjax", "Delta=true"); 
            request.setHeader("X-Requested-With", "XMLHttpRequest");
//          request.setHeader("Content-Length", ""+se.getContentLength()); 
            request.setHeader("Accept-Encoding", "gzip,deflate"); 
            
            
            System.out.println("header:"+request.getAllHeaders());
            System.out.println("baody:"+request.getEntity().toString());
            HttpResponse response = client.execute(request);  
            
//            HttpEntity entity = response.getEntity();
//            String content = EntityUtils.toString(entity);

            Header[] headers = response.getHeaders("Content-Encoding");
            boolean isGzip = false;
            for(Header h:headers){
                if(h.getValue().equals("gzip")){
                        //返回头中含有gzip
                        isGzip = true;
                   }
            }
            String responseString = null;
            if(isGzip){
                //需要进行gzip解压处理
                responseString = EntityUtils.toString(new GzipDecompressingEntity(response.getEntity()));
            }else{
                responseString = EntityUtils.toString(response.getEntity());
            }
            
			System.out.println("response={}"+responseString);
            int code = response.getStatusLine().getStatusCode();  
            if(code == 200){    //请求成功  
//            	BufferedReader is = null;    
                /*in = new BufferedReader(new InputStreamReader(response.getEntity()    
                        .getContent(),"utf-8"));  
               StringBuffer sb = new StringBuffer("");    
                String line = "";    
                String NL = System.getProperty("line.separator");    
                while ((line = in.readLine()) != null) {    
                    sb.append(line + NL);    
                }  
                in.close(); */
                
            }  
            else{   //  
                System.out.println("状态码：" + code);  
                return null;  
            }
			return null;
        }  
        catch(Exception e){  
            e.printStackTrace();  
              
            return null;  
        }  
    }  
    
    /** 
     * post请求（用于请求json格式的参数） 
     * @param url 
     * @param params 
     * @return 
     */  
    public static String doPost(String url, String params) throws Exception {  
          
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        HttpPost httpPost = new HttpPost(url);// 创建httpPost     
        httpPost.setHeader("Accept", "application/json");   
        httpPost.setHeader("Content-Type", "application/json");  
        String charSet = "UTF-8";  
        StringEntity entity = new StringEntity(params, charSet);  
        httpPost.setEntity(entity);          
        CloseableHttpResponse response = null;  
          
        try {  
              
            response = httpclient.execute(httpPost);  
            StatusLine status = response.getStatusLine();  
            int state = status.getStatusCode();  
            if (state == HttpStatus.SC_OK) {  
                HttpEntity responseEntity = response.getEntity();  
                String jsonString = EntityUtils.toString(responseEntity);  
                return jsonString;  
            }  
            else{  
                 logger.error("请求返回:"+state+"("+url+")");  
            }  
        }  
        finally {  
            if (response != null) {  
                try {  
                    response.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
      
} 