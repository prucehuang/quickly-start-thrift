//package pushserver;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.thrift.TException;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TFramedTransport;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//import org.apache.thrift.transport.TTransportException;
//
//import com.inveno.pushserver.thrift.PushCondition;
//import com.inveno.pushserver.thrift.PushResp;
//
///**   
// * @Title: PushHandlerTest.java 
// * @Package pushserver 
// * @Description: TODO(用一句话描述该文件做什么) 
// * @author Michael Shan
// * @date 2016年7月18日 下午4:02:37 
// * @version v1.0.0
// */
//
//public class PushHandlerConsumerTest {
//	private static int port = 18085;
//	private static String ip = "127.0.0.1";
//	private static int timeout = 50000;
//	
//	public static void main(String args[]) throws TException {
////		testPushGroup1();
////		 gcmtest();
//		testPushGroup1();
//	}
//	
//	public static void testPushUid() throws TException {
//		TTransport transport;
//		transport = new TFramedTransport(new TSocket(ip, port, timeout));
//  		try {
//			transport.open();
//		} catch (TTransportException e1) {
//			e1.printStackTrace();
//		}
//		TProtocol protocol = new TBinaryProtocol(transport);
//
//		com.inveno.pushserver.thrift.GcmPush.Client client = new com.inveno.pushserver.thrift.GcmPush.Client(protocol);
//		
//		List<String> uids = new ArrayList<>();
//		uids.add("01011607041704584801000001136700");
//		uids.add("01011607041704584801000001136702");
//		uids.add("01011607041704584801000001136701");
//		uids.add("01011607041704584801000001136703");
////		String msg = readMsg();
//		String msg = "11111";
//		PushResp resp = client.pushUids(uids, msg,"hotoday");
//		
//		System.out.println("result:" + resp.toString());
//		transport.close();
//	}
//		
//	public static void testPushTopic() throws TException {
//		TTransport transport;
//		transport = new TFramedTransport(new TSocket(ip, port, timeout));
//  		try {
//			transport.open();
//		} catch (TTransportException e1) {
//			e1.printStackTrace();
//		}
//		TProtocol protocol = new TBinaryProtocol(transport);
//
//		com.inveno.pushserver.thrift.GcmPush.Client client = new com.inveno.pushserver.thrift.GcmPush.Client(protocol);
//		
////		String msg = readMsg();
//		String msg = "11111";
//		PushResp resp = null/*client.pushTopic("hotoday_India", msg,"hotoday","")*/;
//		
//		System.out.println("result:" + resp.toString());
//		transport.close();
//	}
//	
//	public static String readMsg() {
//		File file = new File("/Users/michael/Documents/svn/zhizi/root/hotodayServer/pushserver/logs/pushtest");
//		BufferedReader reader = null;  
//        try {
//            reader = new BufferedReader(new FileReader(file));  
//            String tempString = null;  
//            int line = 1;  
//            // 一次读入一行，直到读入null为文件结束  
//            while ((tempString = reader.readLine()) != null) {  
//                // 显示行号
//                return tempString;
//            }
//            reader.close();  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        } finally {  
//            if (reader != null) {  
//                try {  
//                    reader.close();  
//                } catch (IOException e1) {  
//                } 
//            }
//        }
//        
//        return "";
//	}
//	
//	public static void gcmtest()
//	{
//		TTransport transport;
//		transport = new TFramedTransport(new TSocket("127.0.0.1", Integer.parseInt("18085"), Integer.parseInt("50000")));
// 		//transport = new TFramedTransport(new TSocket("192.168.9.129", Integer.parseInt("19095"), Integer.parseInt("500000")));
//  		try {
//			transport.open();
//		} catch (TTransportException e1) {
//			e1.printStackTrace();
//		}
//		TProtocol protocol = new TBinaryProtocol(transport);
//		com.inveno.pushserver.thrift.GcmPush.Client client = new com.inveno.pushserver.thrift.GcmPush.Client(protocol);
//		try {
//			PushResp pushRes = null; /*client.pushTopic("11","hotoday" ,"222","");*/
//			System.out.println(pushRes.getCode()+":"+pushRes.getMsg());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	} 
//	
//	public static void testPushGroup() throws TException {
//		TTransport transport;
//		transport = new TFramedTransport(new TSocket(ip, port, timeout));
//  		try {
//			transport.open();
//		} catch (TTransportException e1) {
//			e1.printStackTrace();
//		}
//		TProtocol protocol = new TBinaryProtocol(transport);
//
//		com.inveno.pushserver.thrift.GcmPush.Client client = new com.inveno.pushserver.thrift.GcmPush.Client(protocol);
//		
////		String msg = readMsg();
//		String msg = "11111";
////		List<String> list = new ArrayList<String>();
////		list.add("test");
////		PushResp resp = client.pushUserGroup(list, null, null, null, msg, "hotoday", null);
//		
////		System.out.println("result:" + resp.toString());
////		transport.close();
//	}
//	
//	public static void testPushGroup1() throws TException {
//		TTransport transport;
//		transport = new TFramedTransport(new TSocket(ip, port, timeout));
//  		try {
//			transport.open();
//		} catch (TTransportException e1) {
//			e1.printStackTrace();
//		}
//		TProtocol protocol = new TBinaryProtocol(transport);
//
//		com.inveno.pushserver.thrift.GcmPush.Client client = new com.inveno.pushserver.thrift.GcmPush.Client(protocol);
//		
//		//List<String> promotion, List<String> language, List<String> appver, List<Integer> citycode, String msg, String productid, List<String> uids) throws TException
//		
////		String msg = readMsg();
//		String mesg = "{\"ver\":\"1\",\"cmd\":\"302\",\"data\":{\"content_id\":\"1022474271\",\"sce nario\":\"0x0308ff\",\"link_type\":\"0x00000002\",\"content_type\":\"0x00000001\",\"upack\":\"eyJhYl92ZXIiOiJ1bmtvd24ifQ==\",\"cpack\":\"eyJzdHJhdGVneSI6IjEiLCJjb2 50ZW50X3R5cGUiOiIweDAwMDAwMDAxIn0=\",\"server_time\":1477096202,\"push_title\":\"Cantante Madonna promete sexo oral a quienes voten por Hillary Clinton \",\"push_desc\":\"Cantante Madonna promete sexo oral a quienes voten por Hillary Clinton\",\"title\":\"Cantante Madonna promete sexo oral a quienes vote n por Hillary Clinton\",\"publisher\":\"El Nuevo Diario\",\"link\":null,\"offline_time\":1477756800,\"push_time\":1477324800,\"image\":{\"img_url\":\"\",\"width\":\"\",\"height\":\"\",\"format\":\"\",\"surl\":\"\"},\"notification_style\":{\" priority\":\"2\",\"layout\":\"2\",\"bg_color\":\"#E6FFFFFF\"}}}";
////		String mesg = "222";
//
//		PushCondition pushCondition = initPushCondition();
//		pushCondition.setMsg(mesg);
////		
//		PushResp resp = client.pushUserGroup(pushCondition);
////		
//		System.out.println("result:" + resp.toString());
////		transport.close();
//	}
//	
//	public static PushCondition initPushCondition()
//	{
//		PushCondition pushCondition = new PushCondition();
//		List<String> appver = new ArrayList<String>();
//		appver.add("2.2.2");
//		
//		List<String> language = new ArrayList<String>();
//		language.add("English");
//		
//		List<String> promotion = new ArrayList<String>();
//		promotion.add("gp");
//		
////		List<String> uids = new ArrayList<String>();
////		uids.add("0101160234540645480100008471855");
//		
//		pushCondition.setUids(null);
//		pushCondition.setAppver(appver);
//		pushCondition.setLanguage("English");
//		pushCondition.setProductid("hotoday");
//		pushCondition.setPromotion(promotion);
//		return pushCondition;
//	}
//	
//}
