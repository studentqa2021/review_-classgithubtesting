@SmokeTest
Feature: Login funcation Test
@TC_1233
Scenario:AS a Luma application user,most do successful login with valid credential
Given open any brower
And go to application URL
When click sign in button
And put email
And put password
And click second sigin  button
Then validate login was successful