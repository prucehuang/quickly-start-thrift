package com.git.huanghaifeng.thrift.helloworld;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldClient {

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
			System.out.println("init finish");
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		String res = "";
		if (client != null) {
			try {
				System.err.println(client);
				res = client.HelloWorld(username);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("failed, username = " + username);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// test
		HelloWorldClient client = new HelloWorldClient("localhost", 19090);
		System.out.println("init start");
		if (client.init()) {
			System.out.println("init ok  -- " + client.toString());
			System.out.println(client.helloWorld("huanghaifeng"));
			System.out.println("get data finish");
		} else {
			System.out.println("init failed");
		}
		client.uninit();
	}
}
