package com.git.huanghaifeng.thrift.helloworld;
//package com.git.huanghaifeng.thrift.helloworld;
//
//import java.lang.reflect.Constructor;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.thrift.TProcessor;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.server.TServer;
//import org.apache.thrift.server.TThreadedSelectorServer;
//import org.apache.thrift.transport.TFramedTransport;
//import org.apache.thrift.transport.TNonblockingServerSocket;
//
///**
// * 
// *  Class Name: AlgoCoreServer.java
// *  Description:
// *  
// *  启动thrift服务，给gate调用
// *   
// *  @author liyuanyi  DateTime 2016年1月21日 下午3:31:16 
// *  @company inveno 
// *  @version 1.0
// */
//@SuppressWarnings({ "unchecked", "rawtypes" })
//public class GcmThriftServer {
//	
//	private Log logger = LogFactory.getLog(GcmThriftServer.class);
//	
//	private String algoserverInterface;
//	
//	
//	public String getAlgoserverInterface() {
//		return algoserverInterface;
//	}
//
//	public void setAlgoserverInterface(String algoserverInterface) {
//		this.algoserverInterface = algoserverInterface;
//	}
//	public static GcmThriftServer getSaveInfoService() {
//		return saveInfoService;
//	}
//
//	public static void setSaveInfoService(GcmThriftServer saveInfoService) {
//		GcmThriftServer.saveInfoService = saveInfoService;
//	}
//
//	public static GcmThriftServer saveInfoService;
//
//	public GcmThriftServer() {
//	}
//	
//	/**
//	 * 
//	 *  Description:
//	 *  创建不阻塞Thrift服务器
//	 *  @author liyuanyi  DateTime 2016年1月21日 下午3:36:46
//	 */
//	public void startNonIOServer() {
//		new Thread()
//        {
//            public void run()
//            {
//            	try {
//	            	logger.info("begin start service port = " + Constants.THRIFT_PORT);
//	            	Class algoProcessor = Class.forName(algoserverInterface + "$Processor");  
//	            	Class Iface = Class.forName(algoserverInterface + "$Iface"); 
//	            	Constructor con = algoProcessor.getConstructor(Iface);
//	            	TProcessor tprocessor = (TProcessor) con.newInstance(pushHandler);
//	                // 传输通道 - 非阻塞方式    
//	                TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(Constants.THRIFT_PORT);  
//	                //多线程半同步半异步  
//	                TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverTransport);  
//	                tArgs.processor(tprocessor);  
//	                tArgs.transportFactory(new TFramedTransport.Factory());  
//	                //二进制协议  
//	                tArgs.protocolFactory(new TBinaryProtocol.Factory());  
//	                // 多线程半同步半异步的服务模型  
//	                TServer server = new TThreadedSelectorServer(tArgs);  
//	                server.serve(); // 启动服务
//	    			logger.info("Starting the server Successful....");
//            	} catch (Exception e) {
//            		e.printStackTrace();
//        			logger.error(e,e);
//        		}
//            	
//            };
//        }.start();
//	}
//}
