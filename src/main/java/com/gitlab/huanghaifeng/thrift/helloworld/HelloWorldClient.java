package com.gitlab.huanghaifeng.thrift.helloworld;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldClient{
	
	private static final String CLASS_NAME = HelloWorldClient.class.getSimpleName();
	
	private static final Logger logger = LoggerFactory.getLogger(CLASS_NAME);

	private TTransport transport = null;
	
	private HelloWorldService.Client client = null;
	
	private String server = null;
	
	private int port = -1;
	
	public HelloWorldClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	public boolean init() {
		boolean ret = false;
		
		try {  
            transport = new TFramedTransport(new TSocket(server, port, 5 * 1000));
            TProtocol protocol = new TBinaryProtocol(transport);  
            client = new HelloWorldService.Client(protocol);  
            transport.open();
            
            ret = true;
        } catch (Exception e) {  
            logger.warn(e.getMessage(), e);
        }
		
		return ret;
	}

	public void uninit() {
		if (transport != null) {
			try {
				transport.close();
			} catch (Exception e) {
				logger.warn(e.getMessage(), e);
			}
			
			transport = null;
			client = null;
		}
	}
	
	public String helloWorld(String username) {
		if (client != null) {
			try {
				return client.HelloWorld(username);
			} catch (Exception e) {
				logger.warn("failed, username = {}", username);
			}	
		}
		return "";
	}

	public static void main(String[] args) {
		//test
		HelloWorldClient client = new HelloWorldClient("127.0.0.1", 1234);
		if (client.init()) {
			logger.warn("init ok");
			System.out.println(client.helloWorld("huanghaifeng"));
		} else {
			logger.warn("init failed");
		}
		client.uninit();
	}
}
