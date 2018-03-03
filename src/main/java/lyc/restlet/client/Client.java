package lyc.restlet.client;

public class Client {
	 
    public static final String url = "http://localhost:8082/TestRestlet/";

    public static void main(String args[]){
        
        StudentOperateClient.testGetStudent(url);
//        StudentOperateClient.testUpdateStudent(url);
        
//        TeacherOperateClient.testGetTeacher(url);
//        TeacherOperateClient.testUpdateTeacher(url);
    }
}