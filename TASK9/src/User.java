
public class User {
    private String name;
    private String email;
    private String password;
    private ProfilePicture profile_pic;
    private int semester;
    private Faculty faculty;
    private int uuid;


    public void login(){
        //...
    }
    public void contactSupport(){
        //...
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfilePicture getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(ProfilePicture profile_pic) {
        this.profile_pic = profile_pic;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
}
