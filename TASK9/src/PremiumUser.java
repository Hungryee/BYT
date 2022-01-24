public class PremiumUser  extends User{
    public PremiumUser(String name, String email, String password, ProfilePicture profile_pic, int semester, Faculty faculty, int uuid) {
        super(name, email, password, profile_pic, semester, faculty, uuid);
    }

    public void requestSupportFromModerator(){
        //do stuff with contacting support

        return;
    }
}
