package lyc.restlet.client;
import java.io.IOException;

import org.restlet.data.Form;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class TeacherOperateClient {
    public static void testGetTeacher(String url) {
        ClientResource client = new ClientResource(url + "teacher/1/json");
        try {
            System.out.println("Teacher get " + client.get().getText());
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testAddTeacher(String url) {
        ClientResource client = new ClientResource(url + "teacher/add");
        try {
            Form form = new Form();
            
            form.add("name", "Scott008");
            form.add("subject", "MATH");
            form.add("sex", "0");
            form.add("age", "27");
            
            String id = client.post(form.getWebRepresentation()).getText();
            
            System.out.println("Teacher add " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testUpdateTeacher(String url) {
        ClientResource client = new ClientResource(url + "teacher/update");
        try {
            Form form = new Form();
            
            form.add("age", "28");
            form.add("name", "Scott008");
            form.add("subject", "English");
            form.add("sex", "0");
            form.add("id", "1");
            
            String id = client.put(form.getWebRepresentation()).getText();
            System.out.println("Teacher update " + id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testDeleteTeacher(String url) {
        ClientResource client = new ClientResource(url + "teacher/delete/1");
        try {
            System.out.println("Teacher delete " + client.delete().getText());
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
