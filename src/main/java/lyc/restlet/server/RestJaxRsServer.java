package lyc.restlet.server;

import org.restlet.Component;
import org.restlet.data.Protocol;

import lyc.restlet.application.RestJaxRsApplication;

public class RestJaxRsServer {

	public static void main(String[] args) throws Exception {
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8082);
		component.getDefaultHost().attach(new RestJaxRsApplication(null));
		component.start();

		System.out.println("The restlet server started ...");
	}
}
