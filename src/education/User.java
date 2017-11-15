package education;

public class User {
    private String fullname;
    private String username;
    private String password;
    private String institute;
    private int grade;
    private double skilllevel;


    public User()
    {

    }

    public User(String _username, String _password)
    {
        username=_username;
        password=_password;
    }

    public void setFullname(String _fullname)
    {
        fullname=_fullname;
    }

    public void setUsername(String _username)
    {
        username=_username;
    }

    public void setPassword(String _password)
    {
        password=_password;
    }

    public void setInstitute(String _institute)
    {
        institute=_institute;
    }

    public void setGrade(int _grade)
    {
        grade = _grade;
    }

    public void setSkilllevel(double _skilllevel)
    {
        skilllevel=_skilllevel;
    }

    public String getFullname()
    {
        return fullname;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getInstitute()
    {
        return institute;
    }

    public int getGrade()
    {
        return grade;
    }

    public double getSkilllevel()
    {
        return skilllevel;
    }



}
