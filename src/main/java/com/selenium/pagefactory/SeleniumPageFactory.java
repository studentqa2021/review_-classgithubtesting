package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory{


WebDriver driver;
public SeleniumPageFactory(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements( driver,this);
}

@FindBy(xpath ="//*[@class='authorization-link']")
private List<WebElement> signinBtn;
@FindBy(xpath ="//*[@id='email']")
private WebElement email;
@FindBy(xpath ="//*[@title='Password']")
private WebElement password;
@FindBy(xpath ="//*[@class='action login primary']")
private WebElement secondSigninBtn;
@FindBy(xpath ="//*[@class='greet welcome']")

private List<WebElement> welcome;

@FindBy(xpath ="//*[@id='header_sign_in']")
private List< WebElement> costcoSigininBtn ;
@FindBy(xpath ="//*[@id='navigation-widget']//a")
private List<WebElement> costcoMenuBtn;
@FindBy(xpath ="//*[@class='sub-item']")
private List<WebElement> dealOptions;
@FindBy(xpath ="//*[@class='at-element-marker']")
private List<WebElement> ComputerClick;






public List<WebElement> getComputerClick() {
	return ComputerClick;
}

public List<WebElement> getDealOptions() {
	return dealOptions;
}

public List<WebElement> getCostcoMenuBtn() {
	return costcoMenuBtn;
}

public WebDriver getDriver() {
	return driver;
}

public List<WebElement> getCostcoSigininBtn() {
	return costcoSigininBtn;
}

public List<WebElement> getSigninBtn() {
	return signinBtn;
}
public WebElement getEmail() {
	return email;
}
public WebElement getPassword() {
	return password;
}
public WebElement getSecondSigninBtn() {
	return secondSigninBtn;
}
public List<WebElement> getWelcome() {
	return welcome;
}


}


