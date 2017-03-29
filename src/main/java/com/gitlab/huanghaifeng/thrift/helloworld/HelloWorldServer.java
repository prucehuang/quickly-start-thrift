//package com.gitlab.huanghaifeng.thrift.helloworld;
//
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.gitlab.huanghaifeng.thrift.helloworld.HelloWorldService.Processor;
//
//import org.apache.thrift.protocol.TBinaryProtocol.Factory;
//import org.apache.thrift.server.TServer;
//import org.apache.thrift.server.TThreadPoolServer;
//import org.apache.thrift.server.TThreadPoolServer.Args;
//import org.apache.thrift.transport.TServerSocket;
//import org.apache.thrift.transport.TTransportException;
//
//public class HelloWorldServer {
//	private static final String CLASS_NAME = HelloWorldServer.class.getSimpleName();
//
//	private static final Logger logger = LoggerFactory.getLogger(CLASS_NAME);
//
//	public void startServer() {
//		try {
//			TServerSocket serverTransport = new TServerSocket(1234);
//			Processor<HelloWorldIface> process = new Processor<HelloWorldIface>(new HelloWorldIface());
//			Factory portFactory = new TBinaryProtocol.Factory(true, true);
//
//			Args args = new Args(serverTransport);
//			args.processor(process);
//			args.protocolFactory(portFactory);
//
//			TServer server = new TThreadPoolServer(args);
//			server.serve();
//			System.out.println("server start ok");
//			logger.warn("server start ok");
//		} catch (TTransportException e) {
//			System.out.println("server start faild");
//			logger.warn("server start failed");
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		System.out.println("------1------");
//		HelloWorldServer server = new HelloWorldServer();
//		System.out.println("------2------");
//		server.startServer();
//		System.out.println("------3------");
//	}
//}
