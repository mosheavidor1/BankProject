package infra.page_locators;

public class DepositLocators {

     public static final String DEPOSIT_BUTTON_LOCATOR = "//button[normalize-space()='Deposit']";
     public static final String AMOUNT_INPUT_LOCATOR = "//input[@placeholder='amount']";
     public static final String SUBMIT_BUTTON_LOCATOR = "button[type='submit']";
     public static final String SUCCESS_MESSAGE_LOCATOR = "//span[@class='error ng-binding' and text()='Deposit Successful']";
     public static final String WITHDRAWAL_BUTTON_LOCATOR = "//button[normalize-space()='Withdrawl']";

     public static final String ELEMENT_NOT_FOUND = "Element was not found";
     public static final String ELEMENT_NOT_CLICKABLE = "Element is not clickable";
     public static final String DEPOSIT_SUCCESSFUL = "Deposit successful";
     public static final String ELEMENT_NOT_DISPLAYED = "Element found but not displayed";
     public static final String ELEMENT_NOT_FOUND_TEST_FAILED = "Element not found test failed";

}
