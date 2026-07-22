package Utils;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Commonclass;


import java.io.File;
import java.time.Duration;
import java.util.Set;

public class Utility extends Commonclass {

    public static WebElement getWebElement(By locator) {

        return webDriver.findElement(locator);
    }

    public static void click(WebElement web, String nameOfWebElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            if (web.isDisplayed() && web.isEnabled()) {
                web.click();
                scenario.log("Clicked on the element::"+nameOfWebElement);
                //System.out.println("clicked on the element::" + nameOfWebElement);
            }
        } catch (Exception e) {
            scenario.log("unable to clic on the element::"+nameOfWebElement);
            e.printStackTrace();
            throw new RuntimeException();
            // System.out.println("Unable to click on the element::"+nameOfWebElement);
            // System.out.println("Exception as::"+e.getMessage());

        }
    }

    public static void type(WebElement web, String textToEnter, String nameOfWebElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(web));
            if (web.isDisplayed() && web.isEnabled()) {
                web.click();
                web.clear();
                web.sendKeys(textToEnter);
                System.out.println("Entered text as::" + textToEnter + " on WebElement::" + nameOfWebElement);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
            // System.out.println("unable to Enter text as::"+textToEnter+" on WebElement::"+nameOfWebElement);
            //System.out.println("Exception as::"+e.getMessage());
        }
    }

    public static void selectedByVisibleText(WebElement web, String VisibleText, String nameOfWebElement, String nameOfOptions) {
        try {
            if (web.isDisplayed() && web.isEnabled()) {
                Select obj = new Select(web);
                obj.selectByVisibleText(VisibleText);
                System.out.println("Selected option:" + nameOfOptions + "from webelement" + nameOfWebElement);
            }
        } catch (Exception e) {
            System.out.println("unable to select option:" + nameOfOptions + "from webelement" + nameOfWebElement);
            System.out.println("Exception as::" + e.getMessage());
        }
    }

    public static void selectedByIndex(WebElement web, int index, String nameOfWebElement, String nameOfOptions) {
        try {
            if (web.isDisplayed() && web.isEnabled()) {
                Select obj = new Select(web);
                obj.selectByIndex(index);
                System.out.println("Selected option:" + nameOfOptions + "from webelement" + nameOfWebElement);
            }
        } catch (Exception e) {
            System.out.println("unable to select option:" + nameOfOptions + "from webelement" + nameOfWebElement);
            System.out.println("Exception as::" + e.getMessage());
        }
    }

    public static void selectedByValue(WebElement web, String value, String nameOfWebElement, String nameOfOptions) {
        try {
            if (web.isDisplayed() && web.isEnabled()) {
                Select obj = new Select(web);
                obj.selectByValue(value);
                System.out.println("Selected option:" + nameOfOptions + "from webelement" + nameOfWebElement);
            }
        } catch (Exception e) {
            System.out.println("unable to select option:" + nameOfOptions + "from webelement" + nameOfWebElement);
            System.out.println("Exception as::" + e.getMessage());
        }
    }

    public static void moveToElement(WebElement web, String nameOfTheElement) {
        try {
            if (web.isDisplayed() && web.isEnabled()) {
                Actions act = new Actions(webDriver);
                act.moveToElement(web).build().perform();
                System.out.println("Click action performed on " + nameOfTheElement + " by using mouse");
            }
        } catch (Exception e) {
            System.out.println("Unable to perform click action on" + nameOfTheElement + " by using mouse");
            System.out.println("Exception as:" + e.getMessage());
        }
    }

    public static void rightClick(WebElement web, String nameOfTheElement) {
        try {
            if (web.isDisplayed() && web.isEnabled()) {
                Actions act = new Actions(webDriver);
                act.contextClick(web).build().perform();
                System.out.println("Right Click action performed on " + nameOfTheElement + " by using mouse");
            }
        } catch (Exception e) {
            System.out.println("Unable to perform  right click action on" + nameOfTheElement + " by using mouse");
            System.out.println("Exception as:" + e.getMessage());
        }
    }

    public static void doubleClick(WebElement web, String nameOfTheElement) {
        try {
            if (web.isDisplayed() && web.isEnabled()) {
                Actions act = new Actions(webDriver);
                act.doubleClick(web).build().perform();
                System.out.println("Double Click action performed on " + nameOfTheElement + " by using mouse");
            }
        } catch (Exception e) {
            System.out.println("Unable to perform Double click action on" + nameOfTheElement + " by using mouse");
            System.out.println("Exception as:" + e.getMessage());
        }
    }

    public static void dragAndDrop(WebElement sourceWeb, WebElement targetWeb, String nameOfTheSoureElement, String nameOfTheTargetElement) {
        try {
            if ((targetWeb.isDisplayed() && targetWeb.isEnabled()) && (sourceWeb.isDisplayed() && sourceWeb.isEnabled())) {
                Actions act = new Actions(webDriver);
                act.dragAndDrop(sourceWeb, targetWeb).build().perform();
                System.out.println("Drag and Drop action performed on " + nameOfTheSoureElement + "to" + nameOfTheTargetElement + " by using mouse");
            }
        } catch (Exception e) {
            System.out.println("Unable to perform Drag and drop action on" + nameOfTheSoureElement + "to" + nameOfTheTargetElement + " by using mouse");
            System.out.println("Exception as:" + e.getMessage());
        }
    }

    public static void clickByJavaScriptExecutor(WebElement web, String nameOfTheElement) {
        try {
            if (web.isEnabled() && web.isDisplayed()) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                js.executeScript("arguments[0].click();", web);
                System.out.println("click action performed on " + nameOfTheElement + "by using js executor");
            }
        } catch (Exception e) {
            System.out.println("Unable to perform click action on " + nameOfTheElement + " by using js executor");
            System.out.println("Exception as" + e.getMessage());
        }
    }

    public static void sendkeysByJavaScriptExecutor(WebElement web, String textToEnter, String nameOfTheElement) {
        try {
            if (web.isEnabled() && web.isDisplayed()) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                js.executeScript("arguments[0].setAttribute('value',arguments[1]);",web,textToEnter);
                System.out.println("click action performed on " + nameOfTheElement + "by using js executor");
            }
        } catch (Exception e) {
            System.out.println("Unable to perform click action on " + nameOfTheElement + " by using js executor");
            System.out.println("Exception as" + e.getMessage());
        }
    }

    public static void scrollTillElementVisible(WebElement web, String nameOfTheElement) {
        try {
            if (web.isDisplayed() && web.isEnabled()) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                js.executeScript("arguments[0].scrollIntoView();", web);
                System.out.println("Page scrolled untill the " + nameOfTheElement + "is found");

            }
        } catch (Exception e) {
            System.out.println("Unable to scroll till the " + nameOfTheElement + " is found");
            System.out.println("Error Exception:" + e.getMessage());
        }

    }

    public static void uploadFile(WebElement web, String filePath, String nameOfTheFile) {
        try {
            if (web.isDisplayed() && web.isEnabled()) {
                web.sendKeys(filePath);
            }
        } catch (Exception e) {
            System.out.println("Unable to upload file:" + nameOfTheFile);
        }
    }

    public static void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
    }

    public static void dismissAlert() {
        webDriver.switchTo().alert().dismiss();
    }

    public static void sendTextAlert(String textToEnter) {
        webDriver.switchTo().alert().sendKeys(textToEnter);
    }

    public static String getTextFromAlert() {
        return webDriver.switchTo().alert().getText();
    }

    public static void waitForElement(WebElement web) {
        wait.until(ExpectedConditions.visibilityOf(web));
    }

    public static void switchFrameByName(String name) {
        webDriver.switchTo().frame(name);
    }

    public static void switchFrameById(String Id) {
        webDriver.switchTo().frame(Id);
    }

    public static void switchFrameByIndex(int Index) {
        webDriver.switchTo().frame(Index);
    }

    public static void switchFrameByWebElement(WebElement web) {
        webDriver.switchTo().frame(web);
    }

    public static void exitFrame() {
        webDriver.switchTo().defaultContent();
    }

    public static void acceptAlertUsingExplicitWait() {
        WebDriverWait mywait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        mywait.until(ExpectedConditions.alertIsPresent());
        Alert myalert = webDriver.switchTo().alert();
        myalert.accept();
    }

    public static void dismissAlertUsingExplicitWait() {
        WebDriverWait mywait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        mywait.until(ExpectedConditions.alertIsPresent());
        Alert myalert = webDriver.switchTo().alert();
        myalert.dismiss();
    }

    public static String getAlertTextUsingExplicitWait() {
        WebDriverWait mywait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        mywait.until(ExpectedConditions.alertIsPresent());
        Alert myalert = webDriver.switchTo().alert();
        return myalert.getText();
    }

    public static void sendTextUsingExplicitWait(String textToEnter) {
        WebDriverWait mywait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        mywait.until(ExpectedConditions.alertIsPresent());
        Alert myalert = webDriver.switchTo().alert();
        myalert.sendKeys(textToEnter);
    }

    public static String getTextFromWebElement(WebElement web, String nameoftheElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(web));
            if (web.isDisplayed() && web.isEnabled()) {
                System.out.println("Text from element:" + web.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return web.getText();
    }
    public static File ScreenshotFile(WebDriver webDriver,String filelocation){
        TakesScreenshot ts=(TakesScreenshot) webDriver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File target=new File(filelocation);
        source.renameTo(target);
        return target;
    }
    public static void  pressEnter(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.sendKeys(Keys.ENTER).perform();
    }
    public static void pressTAB(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.sendKeys(Keys.TAB).perform();
    }
    public static void pressEscape(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.sendKeys(Keys.ESCAPE).perform();
    }
    public static void pressArrowDown(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.sendKeys(Keys.ARROW_DOWN).perform();
    }
    public static void pressArrowUp(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.sendKeys(Keys.ARROW_UP).perform();
    }
    public static void pressBackSpace(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.sendKeys(Keys.BACK_SPACE).perform();
    }
    public static void pressDelete(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.sendKeys(Keys.DELETE).perform();
    }
    public static void selectAll(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
    }
    public static void copy(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
    }
    public static void paste(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
    }
    public static void cut(WebDriver webDriver){
        Actions act=new Actions(webDriver);
        act.keyDown(Keys.COMMAND).sendKeys("x").keyUp(Keys.COMMAND).perform();
    }
    public static void switchToWindow(WebDriver webDriver,String windowTitle){
        Set<String>windows=webDriver.getWindowHandles();
        for(String window:windows){
            if(windowTitle.equals(webDriver.getTitle()))
                break;
        }
    }
    public static void closeCurrentWindow(WebDriver webDriver){
        webDriver.close();
    }
    public static void switchToParentWindow(WebDriver webDriver){
        String parent= webDriver.getWindowHandle();
        webDriver.switchTo().window(parent);
    }
    public static void refreshPage(WebDriver webDriver){
        webDriver.navigate().refresh();
    }
    public static void navigateBack(WebDriver webDriver){
        webDriver.navigate().back();
    }
    public static void navigateForward(WebDriver webDriver){
        webDriver.navigate().forward();
    }
    public static void navigateToURL(WebDriver webDriver,String URL){
        webDriver.navigate().to(URL);
    }


}



