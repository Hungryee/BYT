public class ContentModerator  extends User{
    public ContentModerator(String name, String email, String password, ProfilePicture profile_pic, int semester, Faculty faculty, int uuid) {
        super(name, email, password, profile_pic, semester, faculty, uuid);
    }

    public void addTutorial(Tutorial t){
        //do some stuff
    }
    public void addDocument(Document d){
        //...
    }
}
