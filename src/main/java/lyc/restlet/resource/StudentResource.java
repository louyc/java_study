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

import lyc.restlet.modle.Student;

@Path("/TestRestlet/student/")
public class StudentResource {

	@GET
	@Path("{id}/json")
	@Produces("application/json")
	public Student getStudentJson(@PathParam("id") int id) {
		System.out.println("id::"+id);
		return StorageOperator.findStudent(id);
	}

	@POST
	@Path("add")
	public String addStudent(Representation entity) {

		//get parameters from client
		Form form = new Form(entity);
		String name = form.getFirstValue("name");
		int grade = Integer.parseInt(form.getFirstValue("grade"));
		int sex = Integer.parseInt(form.getFirstValue("sex"));
		int age = Integer.parseInt(form.getFirstValue("age"));

		Student student = new Student();
		student.setGrade(grade);
		student.setName(name);
		student.setSex(sex);
		student.setAge(age);

		int id = StorageOperator.studentID + 1;
		student.setId(id);
		return String.valueOf(StorageOperator.addStudent(student));
	}

	@PUT
	@Path("update")
	public String updateStudent(Representation entity) {
		Form form = new Form(entity);

		int id = Integer.parseInt(form.getFirstValue("id"));
		Student student = StorageOperator.findStudent(id);

		if (student == null) {
			return "null";
		}else{
			String name = form.getFirstValue("name");
			int grade = Integer.parseInt(form.getFirstValue("grade"));
			int sex = Integer.parseInt(form.getFirstValue("sex"));
			int age = Integer.parseInt(form.getFirstValue("age"));

			student.setGrade(grade);
			student.setName(name);
			student.setSex(sex);
			student.setAge(age);

			return String.valueOf(StorageOperator.updateStudent(student));
		}
	}

	@DELETE
	@Path("delete/{id}")
	public String deleteStudent(@PathParam("id") int id) {
		int status = StorageOperator.deleteStudent(id);
		return String.valueOf(status);
	}
}
