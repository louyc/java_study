package lyc.restlet.client;
import java.io.IOException;

import org.restlet.data.Form;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class StudentOperateClient {
    public static void testGetStudent(String url) {
        ClientResource client = new ClientResource(url + "student/1/json");
        try {
            System.out.println("Student get " + client.get().getText());
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testAddStudent(String url) {
        ClientResource client = new ClientResource(url + "student/add");
        try {
            Form form = new Form();
            form.add("name", "Scott007");
            form.add("grade", "3");
            form.add("sex", "0");
            form.add("age", "15");
            
            String id = client.post(form.getWebRepresentation()).getText();
            
            System.out.println("Student add " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testUpdateStudent(String url) {
        ClientResource client = new ClientResource(url + "student/update");
        try {
            Form form = new Form();
            form.add("name", "Scott007");
            form.add("grade", "4");
            form.add("sex", "0");
            form.add("id", "1");
            form.add("age", "16");
            
            String id = client.put(form.getWebRepresentation()).getText();
            
            System.out.println("Student update " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testDeleteStudent(String url) {
        ClientResource client = new ClientResource(url + "student/delete/1");
        try {
            System.out.println("Student delete " + client.delete().getText());
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}