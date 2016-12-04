package HW3.Data;

public enum LogInPageData {
    USER_NAME_INPUT_ID_LOGIN_PAGE("username"),
    PASSWORD_INPUT_ID_LOGIN_PAGE("password"),
    USER_NAME_INPUT_VALUE_LOGIN_PAGE("admin"),
    PASSWORD_INPUT_VALUE_LOGIN_PAGE("123"),
    LOGIN_BUTTON_INPUT_ID_LOGIN_PAGE("logIn"),
    ERROR_MESSAGE_XPATH_LOGIN_PAGE(".//ul[@class='errors']/li"),
    ERROR_MESSAGE_TEXT_LOGIN_PAGE("Invalid username or password"),
    TITLE_LOGIN_PAGE("Login"),
    INCORRECT_PASSWORD_INPUT_VALUE_PAGE("12345"),
    INCORRECT_USER_NAME_INPUT_VALUE_PAGE("&"),
    ERROR_MESSAGE_EMPTY_USER_NAME_XPATH_LOGIN_PAGE(".//dd[@id='username-element']/ul/li"),
    ERROR_MESSAGE_EMPTY_PASSWORD_XPATH_LOGIN_PAGE(".//dd[@id='password-element']/ul/li"),
    ERROR_MESSAGE_EMPTY_USER_NAME_TEXT_LOGIN_PAGE("Value is required and can't be empty"),
    ERROR_MESSAGE_EMPTY_PASSWORD_TEXT_LOGIN_PAGE("Value is required and can't be empty");


    private String value;

    LogInPageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
