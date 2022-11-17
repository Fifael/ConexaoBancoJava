import java.sql.PreparedStatement;

public class Usuario {

    private int user_id;
    private String userName;
    private String name;
    private String password;

    public Usuario(String userName, String name, String password) throws Exception {
        this.userName = userName;
        this.name = name;
        this.password = password;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
                "INSERT INTO usuario (user_name, name, password) VALUES (?, ?, ?);");
        stmt.setString(1, this.getUserName());
        stmt.setString(2, this.getName());
        stmt.setString(3, this.getPassword());
        stmt.execute();
        DAO.closeConnection();
    }

    public Usuario(int user_id, String userName, String name, String password) {
        this.user_id = user_id;
        this.userName = userName;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "Usuario{"
                + "id=" + user_id
                + ", userName=" + userName
                + ", name=" + name
                + ", password=" + password + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Usuario)) {
            return false;
        }
        final Usuario other = (Usuario) object;

        return this.user_id == other.user_id;
    }
}