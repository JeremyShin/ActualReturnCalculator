package my.examples.arc.dto;

public class    ArcLoginDTO {
    private int memberIndex;
    private String Id;
    private String name;
    private String password;
    private String email;

    public int getMemberIndex() {
        return memberIndex;
    }

    public void setMemberIndex(int memberIndex) {
        this.memberIndex = memberIndex;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
