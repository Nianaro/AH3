package HW3.Data;

public enum PathsData {
    URL("http://80.92.229.236:81"),
    LOGIN_PAGE("/auth/login");

    private String path;

    PathsData(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
