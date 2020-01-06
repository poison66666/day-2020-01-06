import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ParseURL {
    private static Map<String,Integer> knownPorts = new HashMap<>();
    static {
        knownPorts.put("http",80);
        knownPorts.put("https",443);
        knownPorts.put("jdbc:mysql",3306);
    }
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        int index;
//        String url = "https://" +
//                "www.baidu.com/" +
//                "s?" +
//                "wd=c%2B%2B&rsv_spt=1&rsv_iqid=0xacf67e9700058393&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_dl=tb&rsv_enter=1&rsv_sug3=3&rsv_sug1=3&rsv_sug7=101&rsv_sug2=0&inputT=6052&rsv_sug4=13010";
//        index = url.indexOf("://");
//        String schema = url.substring(0,index);
//        url = url.substring(index+3);
//        System.out.println(schema);
//
//        index = url.indexOf("/");
//        String hostAndPort = url.substring(0,index);
//        url = url.substring(index+1);
//        String host;
//        int port;
//        if(hostAndPort.contains(":")){
//            String[] group = hostAndPort.split(":");
//            host = group[0];
//            port = Integer.valueOf(group[1]);
//        }else{
//            host = hostAndPort;
//            port = knownPorts.get(schema);
//        }
//        System.out.println(host);
//        System.out.println(port);
//
//        index = url.indexOf("?");
//        String path = url.substring(0,index);
//        url = url.substring(index+1);
//        System.out.println(path);
//
//        String queryString;  //查询字符串
//        String segment = ""; //片段标识符
//        index = url.indexOf("#");
//        if(index != -1){
//            queryString = url.substring(0,index);
//            segment = url.substring(index+1);
//        }else{
//            queryString = url;
//        }
//
//        String[] kv = queryString.split("&");
//        for(String s : kv){
//            //以UTF-8方式解码
//            System.out.println(URLDecoder.decode(s,"UTF-8"));
//        }
//        System.out.println(segment);
//    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "?";
        String s1 = URLEncoder.encode(s,"UTF-8");
        String s2 = URLDecoder.decode(s1,"UTF-8");
        System.out.println(s1);
        System.out.println(s2);
    }
}
