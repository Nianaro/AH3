package HW3.Data;

public enum PlayersPageData {
    INSERT_LINK_XPATH_PLAYERS_PAGE(".//a[contains(@href,'/players/insert')]"),
    EMAIL_INPUT_XPATH_PLAYERS_PAGE(".//input[contains(@id,'__email')]"),
    SEARCH_BUTTON_INPUT_XPATH_PLAYERS_PAGE(".//input[contains(@value,'Search')]"),
    EDIT_LINK_XPATH_PLAYERS_PAGE(".//tr[.//a[text()='email']]//img[@alt='Edit']"),
    TITLE_PLAYERS_PAGE("Players"),
    DELETE_USER_BUTTON_XPATH_PLAYERS_PAGE(".//img[@alt='Delete']"),
    DELETE_MESSAGE_XPATH_PLAYERS_PAGE(".//div[contains(@id,'datagrid_flash')]/ul/li"),
    DELETE_MASSEGE_TEXT_PLAYERS_PAGE("Player has been deleted");

    private String xpath;

    PlayersPageData(String xpath) {
        this.xpath = xpath;
    }

    @Override
    public String toString() {
        return xpath;
    }
}
