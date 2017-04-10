package com.git.huanghaifeng.thrift.helloworld;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.git.huanghaifeng.thrift.helloworld.HelloWorldService.Processor;

public class HelloWorldServer {
	private static final String CLASS_NAME = HelloWorldServer.class.getSimpleName();

	private static final Logger logger = LoggerFactory.getLogger(CLASS_NAME);

	public void startServer() {

		try {
			TServerTransport serverTransport = new TServerSocket(19090);
			Processor<HelloWorldIface> processor = new Processor<HelloWorldIface>(new HelloWorldIface());
			Factory portFactory = new TBinaryProtocol.Factory();

			Args args = new Args(serverTransport);
			args.processor(processor);
			args.protocolFactory(portFactory);

			//TServer server = new TSimpleServer(args);

			// Use this for a multithreaded server
			//TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
			TServer server = new TThreadPoolServer(args);
			
			System.out.println("Starting the simple server...");
			server.serve();
		} catch (Exception e) {
			System.out.println("server start faild");
			logger.warn("server start failed");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("------1------");
		HelloWorldServer server = new HelloWorldServer();
		System.out.println("------2------");
		server.startServer();
		System.out.println("------3------");
	}
}
