package lyc.restlet.resource;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.restlet.data.Form;
import org.restlet.representation.Representation;

import lyc.restlet.modle.Teacher;

@Path("/TestRestlet/teacher/")
public class TeacherResource {
	@GET
	@Path("{id}/json")
	@Produces("application/json")
	public Teacher getTeacherJson(@PathParam("id") int id) {
		return StorageOperator.findTeacher(id);
	}

	@POST
	@Path("add")
	public String addTeacher(Representation entity) {

		//get parameters from client
		Form form = new Form(entity);
		String name = form.getFirstValue("name");
		String subject = form.getFirstValue("subject");
		int sex = Integer.parseInt(form.getFirstValue("sex"));
		int age = Integer.parseInt(form.getFirstValue("age"));

		Teacher teacher = new Teacher();
		teacher.setSubject(subject);
		teacher.setName(name);
		teacher.setSex(sex);
		teacher.setAge(age);

		int id = StorageOperator.teacherID + 1;
		teacher.setId(id);
		return String.valueOf(StorageOperator.addTeacher(teacher));
	}

	@PUT
	@Path("update")
	public String updateTeacher(Representation entity) {
		Form form = new Form(entity);

		int id = Integer.parseInt(form.getFirstValue("id"));
		Teacher teacher = StorageOperator.findTeacher(id);

		if (teacher == null) {
			return "null";
		}else{
			String name = form.getFirstValue("name");
			String subject = form.getFirstValue("subject");
			int sex = Integer.parseInt(form.getFirstValue("sex"));
			int age = Integer.parseInt(form.getFirstValue("age"));

			teacher.setSubject(subject);
			teacher.setName(name);
			teacher.setSex(sex);
			teacher.setAge(age);

			return String.valueOf(StorageOperator.updateTeacher(teacher));
		}
	}

	@DELETE
	@Path("delete/{id}")
	public String deleteTeacher(@PathParam("id") int id) {
		int status = StorageOperator.deleteTeacher(id);
		return String.valueOf(status);
	}
}