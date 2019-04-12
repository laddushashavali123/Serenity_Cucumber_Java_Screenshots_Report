package com.lumbela.SerenityCucumberTemplate.utils;

import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Laddu shashavali
 */
public class WebDriverUtils {

    public static final int DEFAULT_WAIT_TIME = 10;
    private WebDriver driver;
    public WebDriverUtils(WebDriver driver) {
        this.driver=driver;
        System.out.println("Driver instance: "+driver.getWindowHandle());
       // super(driver);
    }

    public FluentWait<WebDriver> fluentWait(){
        return fluentWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    public FluentWait<WebDriver> fluentWait(int duration, TimeUnit timeUnit){
        return new FluentWait<WebDriver>(driver)
                .withTimeout(duration, timeUnit)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoreAll(new ArrayList<Class<? extends Throwable>>(){
                    {
                        add(StaleElementReferenceException.class);
                        add(NoSuchElementException.class);
                    }
                }).withMessage("Selenium Timeout Exception");
    }

    public WebElement waitForElement(final By locator){

        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(locator);
            }
        });
        return foo;
    }

    public WebElement waitForElementDisplayed(final By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                WebElement element = driver.findElement(locator);
                if(element != null && element.isDisplayed()){
                    highlight(element);
                    return element;
                }else{
                    return null;
                }
            }
        });
        return foo;
    }

    public WebElement waitForElementDisplayed(final WebElement element){

        //driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
              //  WebElement element = driver.findElement(locator);
                if(element != null && element.isDisplayed()){
                    scrollToElement(element);
                    highlight(element);
                    return element;
                }else{
                    return null;
                }
            }
        });
        return foo;
    }
    public WebElement textToBePresentInElementLocated(By by, String textToWait, TimeUnit timeUnit){
        Boolean found = false;
        WebElement element = null;
        try {
            element = driver.findElement(by);
            found = fluentWait(DEFAULT_WAIT_TIME, timeUnit).until(ExpectedConditions.textToBePresentInElementLocated(by, textToWait));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        if(!found) {
            System.out.println("Element with the text '" + textToWait + "' not found");
            return  null;
        }

        return element;
    }

    public void waitForVisibilityOfElement(final WebElement element){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfElement(By locator){
        WebElement element = driver.findElement(locator);
        waitForVisibilityOfElement(element);
    }

    public void waitForPageTitle(String title){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForPageTitleContains(String title){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void waitForInvisibilityOfElement(By locator){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementAttributeContains(final WebElement element, String attributeName, String attributeValue){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.attributeContains(element,attributeName,attributeValue));
    }

    public void waitForElementAttributeContains(By locator, String attributeName, String attributeValue){
        WebElement element = driver.findElement(locator);
        waitForElementAttributeContains(element,attributeName,attributeValue);
    }

    public void waitForElementTextToBe(By locator, String text){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.textToBe(locator,text));
    }

    public boolean isClickable(final WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void highlight(final WebElement element){
        for(int i=0; i<2; i++){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid blue");
            delay(200);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
             delay(200);
        }
    }

    public void jsClick(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Declare and set the start time
        long start_time = System.currentTimeMillis();
        //Call executeAsyncScript() method to wait for 5 seconds
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        //Get the difference (currentTime - startTime)  of times.
        System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
        js.executeScript("arguments[0].click();", element);
       // js.executeScript("var el=arguments[0]; setTimeout(function() {e1.click();}, 100);", element);
    }

    public void jsRadioButtonCheck(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Declare and set the start time
        long start_time = System.currentTimeMillis();
        //Call executeAsyncScript() method to wait for 5 seconds
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        //Get the difference (currentTime - startTime)  of times.
        System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid blue");
        delay(200);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        delay(200);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", element);
    }
    public void checkPageIsReady() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Page Is loaded.");
            return;
        }
        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        int count =0;
        if((Boolean) js.executeScript("return window.jQuery != undefined")){
            while(!(Boolean) js.executeScript("return jQuery.active == 0")){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {}
                if(count>4)
                    break;
                count++;
            }
        }
        for (int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }
    }
    public void actionClick(final WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void scrollToElement(final WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        delay(200);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void ScrollToElementAndClick(final WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        delay(200);
        js.executeScript("arguments[0].click();", element);
        delay(200);
    }
    public void delay(int timeInMilli){
        try {
            Thread.sleep(timeInMilli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Method to retrieve texts from all the cells (All rows & columns)
    public void getAllCellText(By by){
        List<WebElement> rows = driver.findElements(by);
        for(int i=0; i<rows.size(); i++){
            WebElement row = rows.get(i);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for(int j=0; j<cols.size(); j++){
                WebElement col = cols.get(j);
                String text = col.getText();
                System.out.println("Cell Text: " + text);
            }
        }
    }

    // Method to retrieve texts from all the cells as an Array (All rows & columns)
    public String[][] getAllCellTextArray(By by){
        String[][] tableText = null;    // declare an array called tableText
        List<WebElement> rows = driver.findElements(by); //find all the rows
        tableText = new String[rows.size()][];   //Initialize (size) the array with the total number of rows

        for(int i=0; i<rows.size(); i++){
            WebElement row = rows.get(i); //Retrieve what's in row[0]
            List<WebElement> cols = row.findElements(By.tagName("td"));
            tableText[i] = new String[cols.size()]; //Initialize (size) the array with the total number of columns for that particular row[i]
            for(int j=0; j<cols.size(); j++){
                WebElement col = cols.get(j);
                String text = col.getText();
                tableText[i][j] = text;
            }
        }
        return tableText;
    }

    // Method to retrieve texts from all the cells as an Array (All rows & columns) (Overloaded method)
    public String[][] getAllCellTextArray(final WebElement element){
        String[][] tableText = null;    // declare an array called tableText
        List<WebElement> rows = element.findElements(By.xpath(".//tbody/tr")); //find all the rows
        tableText = new String[rows.size()][];   //Initialize (size) the array with the total number of rows

        for(int i=0; i<rows.size(); i++){
            WebElement row = rows.get(i); //Retrieve what's in row[0]
            List<WebElement> cols = row.findElements(By.tagName("td"));
            tableText[i] = new String[cols.size()]; //Initialize (size) the array with the total number of columns for that particular row[i]
            for(int j=0; j<cols.size(); j++){
                WebElement col = cols.get(j);
                String text = col.getText();
                tableText[i][j] = text;
            }
        }
        return tableText;
    }
    //Method to Hover over an element
    public void hoverAction(final WebElement element){
        highlight(element);
        delay(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    //Mouse Hover element with Locatable and Mouse class
    public void hoverLocatable(final WebElement element){
        highlight(element);
        Locatable hoverItem = (Locatable) element;
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(hoverItem.getCoordinates());
    }

    //Method to hover over an element using JavaScript Executor
    public void mouseHoverJScript(final WebElement HoverElement) {
        highlight(HoverElement);
        try {
            if (isElementPresent(HoverElement)) {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
            } else {
                System.out.println("Element was not visible to hover " + "\n");
            }

        } catch (StaleElementReferenceException e) {
            System.out.println("Element with " + HoverElement
                    + "is not attached to the page document"
                    + e.getStackTrace());
        }
    }

    public static boolean isElementPresent(final WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        } catch (StaleElementReferenceException e) {
            flag = false;
        }
        return flag;
    }
    //Method to capture ScreenShot
    public String captureScreenShot(WebDriver driver, String screenshotName){
        String destinationPath=System.getProperty("user.dir") + "\\output\\screenshots\\" + screenshotName + ".png";
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(destinationPath);
            // Files.copy(sourcePath, destinationPath);
            String imagePath = destinationFile.getCanonicalPath();
            System.out.println("Image path is: " + imagePath);
           /* if (!destinationFile.exists()) {
                FileUtils.touch(destinationFile);
            }*/
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("ScreenShot taken...at: "+destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationPath;
    }
    public static void emailReport(String sendTo, String subject, String message){
        Email email = new SimpleEmail();
        try {
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("shasha.intell@gmail.com", "shasha@432"));
            email.setSSLOnConnect(true);
            email.setFrom("shasha.intell@gmail.com");
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(sendTo);
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printCurrentURL(){
        String url = driver.getCurrentUrl();
        System.out.println("Current Page URL: " + url);
    }

    public void printPageTitle(){
        String title = driver.getTitle();
        System.out.println("Current Page Title: " + title);
        System.out.println("----------------------------------------------------------------------");
    }

    public void printPageSource(){
        String source = driver.getPageSource();
        System.out.println("Current Page Source: \n" + source);
    }

    public void dragAndDrop(By elementFrom, By elementTo){
        WebElement from = driver.findElement(elementFrom);
        highlight(from);

        WebElement to = driver.findElement(elementTo);
        highlight(to);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to).build().perform();
        delay(2000);
    }

    public void datePicker(By locatorUpToTableRow, String chosenDate) {
        List<WebElement> rows = driver.findElements(locatorUpToTableRow);
        for(WebElement row : rows){
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for(WebElement col : cols){
                String date = col.getText();
                if(date.contains(chosenDate)){
                    System.out.println(col.getText());
                    col.click();
                    break;
                }
            }
        }
    }
    public String getLastWindowHandle(){
        Set<String> listOfWindows = driver.getWindowHandles();
        return listOfWindows.toArray()[listOfWindows.size()-1].toString(); //Returns the last windows as a string
    }

    public void switchToLastWindow(){
        String win = getLastWindowHandle(); //Calls the previous method to get the last window
        driver.switchTo().window(win); //Switches to the "win"(the last window -- #2 in this case) window
    }

    public void closeLastWindow(){
        switchToLastWindow(); //Switch to last window using the previous method
        driver.close();
    }

    //Method to switch to a window by using the "page title"
    public void switchToWindow(String winTitle){
        Set<String> winHandles = driver.getWindowHandles(); //Provides a set of all the windows that has opened
        Iterator<String> iterator = winHandles.iterator();  //To iterate through the Set of elements
        while (iterator.hasNext()){
            String win = iterator.next(); //To get the next window as a String
            driver.switchTo().window(win); //Switch to the next window
            String currentPageTitle = driver.getTitle();
            if(currentPageTitle.contains(winTitle)){
                return;
            }
        }
        throw new RuntimeException("Window with the Title contain '" + winTitle + "' not found.");
    }

    //Method to switch to a window by using the "page URL"
    public void switchToWindowbyURL(String url){
        Set<String> winHandles = driver.getWindowHandles(); //Provides a set of all the windows that has opened
        Iterator<String> iterator = winHandles.iterator();  //To iterate through the Set of elements
        while (iterator.hasNext()){
            String win = iterator.next(); //To get the next window as a String
            driver.switchTo().window(win); //Switch to the next window
            String currentURL = driver.getCurrentUrl(); //Get the current page's URL
            if(currentURL.contains(url)){
                return;
            }
        }
        throw new RuntimeException("Window with the URL '" + url + "' not found.");
    }

    //Method to switch to a window by using the "page Index" (Overloaded Method) (But how to get the index -- Ask teacher... P.S: 0 and 1 isn't working)
    public void switchToWindow(int winIndex){
        Set<String> winHandles = driver.getWindowHandles(); //Provides a set of all the windows that has opened

        if(winIndex < winHandles.size()){
            String win = winHandles.toArray()[winIndex].toString();
            driver.switchTo().window(win);
        }

        throw new RuntimeException("Window with the index '" + winIndex + "' not found.");
    }

    //Method to close a window with a given Title
    public void closeWindow(String title){
        switchToWindow(title); //Switch to the window with the given title
        driver.close();
        switchToLastWindow();
    }

    //Method to close a window with a given Index (But how to get the index -- Ask teacher... P.S: 0 and 1 isn't working)
    public void closeWindow(int winIndex){ //Overloaded Method
        switchToWindow(winIndex); //Switch to the window with the given Index
        driver.close();
        switchToLastWindow();
    }

    public void closeAllOpenWindowExceptCurrent(){
        String currentWindow = driver.getWindowHandle();
        Set<String> windowList = driver.getWindowHandles();
        for(String x : windowList){
            if(!currentWindow.contentEquals(x)){ //If "x" is not the current window, then switch to window "x" and then close it
                driver.switchTo().window(x);
                driver.close();
            }
        }
        driver.switchTo().window(currentWindow); //Switch back to the first window
    }
    public boolean isElementDisplayed(WebElement element) {
        boolean flag = false;
        try {
            element.isDisplayed();
            flag = true;
        } catch (Exception e) {

        }
        return flag;

    }

    public boolean isElementDisplayed(By element) {
        boolean flag = false;
        try {
            driver.findElement(element).isDisplayed();
            flag = true;
        } catch (Exception e) {

        }
        return flag;

    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /*public void waitForElementJS(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( new Predicate<WebDriver>() {
                        public boolean apply(WebDriver driver) {
                            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                        }
                    }
        );
    }*/
    public void waitForElementToBeVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public boolean waitForJStoLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }


}
