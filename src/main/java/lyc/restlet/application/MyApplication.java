package lyc.restlet.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import lyc.restlet.resource.StudentResource;
import lyc.restlet.resource.TeacherResource;

public class MyApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();

		resources.add(StudentResource.class);
		resources.add(TeacherResource.class);

		return resources;
	}
}
