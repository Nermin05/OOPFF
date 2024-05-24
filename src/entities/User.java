package entities;

public class User{
    private String name;
    private String email;
    private String password;
    private String passwordAgain;
   private double X;
   private double Y;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, String email, String password, String passwordAgain) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.passwordAgain=passwordAgain;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public double getY() {
        return Y;
    }



    public double getX() {
        return X;
    }



    public User(double x,double y) {
       this.X = x;
       this.Y = y;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }


}
