package education;
import java.sql.*;
import java.io.File;

public class UserDatabase {

    //User newUser = new User();
    Connection con=null;
    static Statement statement;
    static ResultSet result;
    File file = new File("input.txt");

    public UserDatabase()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","mayosenpai","mayosenpai");
            statement=con.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void setUserValues(User newuser)
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
    }

    public void changeUserFullname(String username, String fullname)
    {
        try
        {
            int x = statement.executeUpdate("UPDATE USERDATABASE SET FULLNAME='" + fullname + "' WHERE USERNAME='" + username + "'");
            System.out.println("changed fullname to "+fullname);
            System.out.println(x);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void changeUserPassword(String username, String password)
    {
        try
        {
            int x =statement.executeUpdate("UPDATE USERDATABASE SET PASSWORD='" + password + "' WHERE USERNAME='" + username + "'");
            System.out.println(x);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void changeGrade(String username, String grade)
    {
        try
        {
            int intgrade = Integer.parseInt(grade);
            int x =statement.executeUpdate("UPDATE USERDATABASE SET GRADE='" + intgrade + "' WHERE USERNAME='" + username + "'");
            System.out.println(x);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void changeInstitute(String username, String institute)
    {
        try
        {
            int x =statement.executeUpdate("UPDATE USERDATABASE SET INSTITUTE='" + institute + "' WHERE USERNAME='" + username + "'");
            System.out.println(x);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateScore(String username, int _score)
    {
        try
        {
            int x =statement.executeUpdate("UPDATE USERDATABASE SET skilllevel='" + _score + "' WHERE USERNAME='" + username + "'");
            System.out.println(x);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }



}