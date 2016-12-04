package HW3.Data;

public enum EditPlayerPageData {
    USER_NAME_INPUT_XPATH_INSERT_EDIT_PAGE (".//input[contains(@id,'us_login')]"),
    EMAIL_INPUT_XPATH_INSERT_EDIT_PAGE(".//input[contains(@id,'email')]"),
    PASSWORD_INPUT_XPATH_INSERT_EDIT_PAGE(".//input[contains(@id,'us_password')]"),
    CONFIRM_PASSWORD_INPUT_XPATH_INSERT_EDIT_PAGE(".//input[contains(@id,'confirm_password')]"),
    FIRST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE(".//input[contains(@id, 'fname')]"),
    LAST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE(".//input[contains(@id, 'lname')]"),
    CITY_INPUT_XPATH_INSERT_EDIT_PAGE(".//input[contains(@id, 'city')]"),
    COUNTRY_SELCT_XPATH_INSERT_EDIT_PAGE(".//select[contains(@id,'country')]"),
    ADDRESS_TEXTAREA_XPATH_INSERT_EDIT_PAGE(".//textarea[contains(@id, 'address')]"),
    PHONE_INPUT_XPATH_INSERT_EDIT_PAGE(".//input[contains(@id, 'phone')]"),
    SAVE_BUTTON_INPUT_XPATH_INSERT_EDIT_PAGE(".//input[@value='Save']"),

    NEW_USER_EMAIL_DOMEN_INPUT_VALUE_INSERT_EDIT_PAGE("@gmail.com"),
    NEW_USER_FIRST_NAME_INPUT_VALUE_INSERT_EDIT_PAGE("FN"),
    NEW_USER_LAST_NAME_INPUT_VALUE_INSERT_EDIT_PAGE("LN"),
    NEW_USER_COUNTRY_INPUT_VALUE_INSERT_EDIT_PAGE("UK"),
    NEW_USER_CITY_INPUT_VALUE_INSERT_EDIT_PAGE("Kharkov"),
    NEW_USER_ADDRESS_INPUT_VALUE_INSERT_EDIT_PAGE("address"),
    NEW_USER_PHONE_INPUT_VALUE_INSERT_EDIT_PAGE("+1234567890"),

    EDIT_USER_FIRST_NAME_INPUT_VALUE_INSERT_EDIT_PAGE("First Name"),
    EDIT_USER_LAST_NAME_INPUT_VALUE_INSERT_EDIT_PAGE("Last name"),
    EDIT_USER_CITY_INPUT_VALUE_INSERT_EDIT_PAGE("Kiev"),
    EDIT_USER_ADDRESS_INPUT_VALUE_INSERT_EDIT_PAGE("New"),
    EDIT_USER_PHONE_INPUT_VALUE_INSERT_EDIT_PAGE("no phone"),

    TITLE_EDIT_PAGE("Players - Edit");

    private String value;

    EditPlayerPageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
