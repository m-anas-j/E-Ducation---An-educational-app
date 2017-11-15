package education;
import java.sql.*;
import java.io.File;

public class QuizDatabase {

    //User newUser = new User();
    Connection con=null;
    static Statement statement;
    static ResultSet result;
    File file = new File("input.txt");

    String quizID = "04En01";
    String [] question;
    String [] choiceA;
    String [] choiceB;
    String [] choiceC;
    String [] choiceD;
    String [] answer;

    public QuizDatabase(String ID)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","mayosenpai","mayosenpai");
            statement=con.createStatement();
            System.out.println("Connection to quiz database successful");
            //quizID=ID;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /*public static void setUserValues(User newuser)
    {
        try
        {
            String fullname;
            String username;
            String password;
            String institute;
            int grade;
            double skilllevel=0;
            fullname = newuser.getFullname();
            username = newuser.getUsername();
            password = newuser.getPassword();
            institute = newuser.getInstitute();
            grade = newuser.getGrade();
            statement.executeUpdate("insert into userdatabase values ('" + fullname + "','" + username + "','" + password + "','" + institute + "'," + grade + "," + skilllevel + ")");
            statement.executeUpdate("COMMIT ");
            result = statement.executeQuery("select * from userdatabase");
            while(result.next())
            {
                String username1= result.getString(2);
                String name= result.getString(1);
                String password1 = result.getString(3);
                String institute1 = result.getString(4);
                String grade1 = result.getString(5);
                String skill1 = result.getString(6);
                System.out.println(name + " " + username1 + " " + password1 + " " + institute1 + " " + grade1 + " " + skill1);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }*/

    public void setQuestion()
    {
        System.out.println("Inside setQuestion of quizdatabase and quiz "+quizID);
        /*try
        {
            result = statement.executeQuery("SELECT * FROM QUIZDATABASE WHERE ID='"+quizID+"'");
            while(result.next())
            {
                System.out.println("Inside first loop");
                int i=1;
                question[i] = result.getString(2);
                QuestionScreenController.question[i]=this.question[i];
                choiceA[i] = result.getString(3);
                QuestionScreenController.A[i]=this.choiceA[i];
                choiceB[i] = result.getString(4);
                QuestionScreenController.B[i]=this.choiceB[i];
                choiceC[i] = result.getString(5);
                QuestionScreenController.C[i]=this.choiceC[i];
                choiceD[i] = result.getString(6);
                QuestionScreenController.D[i]=this.choiceD[i];
                answer[i] = result.getString(7);
                QuestionScreenController.answer[i]=this.answer[i];
                i++;
                System.out.println(question[i]+ " " + choiceA[i] + " " + choiceB[i] + " " + choiceC[i] + " " + choiceD[i] + " " + answer[i]);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }*/
    }





}