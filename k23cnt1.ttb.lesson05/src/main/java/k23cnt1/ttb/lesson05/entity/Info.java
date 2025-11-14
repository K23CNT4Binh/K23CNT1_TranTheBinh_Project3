package k23cnt1.ttb.lesson05.entity;

public class Info {
    private String name;
    private String username;
    private String nickName;
    private String email;
    private String website;
    private String description;
    private String phone;

    // Constructor mặc định
    public Info() {}

    // Constructor đầy đủ
    public Info(String name, String username, String nickName,
                String email, String website, String description, String phone) {
        this.name = name;
        this.username = username;
        this.nickName = nickName;
        this.email = email;
        this.website = website;
        this.description = description;
        this.phone = phone;
    }

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNickName() { return nickName; }
    public void setNickName(String nickName) { this.nickName = nickName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
