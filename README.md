# Sabeeka-Rasul
Home Challenge



**Exploratory testing charters**

Purpose: To test out the Monefy application on iOS to find out issues that can be faced by the users. 

Date when the activity is carried out: 12-07-2022

Duration of this activity: 2 hours 

Scope of testing: All flows of the application which are available free for the users including the user experience. 

Application components tested: Onboarding flow, dashboard, categories, filters, accounts, settings, adding expense & income flow. 

**Findings and bugs:**

Following were the bugs found in the application: 

- Onboarding flow of the application does not let the user swipe right or left. 
- While on the onboarding screens closing the application finishes the onboarding. 
- Help text in the application is not in symmetry to actually help the user understand the flow of the application. 
- On the main dashboard screen where the pie chart shows the user’s expenses, it doesn’t reflect the actual data the user has entered. 
- While adding income or expense on the add notes section there’s no way to close the keyboard tapping anywhere outside the keyboard doesn't close it except if you tap on the numeric field. (Swiping down should close the keyboard)
- While adding expense or income when keyboard opens the calculator is still active and if clicked on any numeric value on the calculator that is added on the income field while the ‘add notes’ text field is also active. 
- In the categories section if any category is disabled that disabled category is still shown in the more category section. 
- In the category section when a category is selected and the user changes the selection the name of the category first selected is shown at the top and is not updated. 
- If a setting is applied there’s no way for the user to know if it gets applied or not, no visual feedback or change is shown. 
- If a period isn’t selected from filters the main home page shouldn’t show the text “ There is no records for this period yet” 
- In the settings section the text, numbers and icons are not aligned. Size of the icons is different as well. 
- When the ‘Buy’ screen appears, at the bottom ‘restore’ button is shown which is useless as  the user hasn’t bought anything before so there’s nothing to restore.
- While adding a card add the initial amount, it doesn’t reset the field istead the placeholder ‘0’ gets added to the amount you add,  
- While adding the income and expense using the calculator when adding the amount removing the amount added doesn't ‘clear all’ if the user adds a number it gets added into previously cleared out amount. 


**Prioritisation of the charters**

The order in which I prioritized the charters: 
P[0] Testing the entire application functionally. 
P[1] Testing the entire application with respect to user experience. 
I explored the basic functionality first so that I could verify that the application does what it is supposed to do. 



**Time planned for each charter: ******

I divided the time equally for both charters and spent 1 hour each. 




**Risks that needed mitigation:** 

User’s data protection: 
The application is not login or password protected so user’s data is not protected. 

Security breach:
If the application is not tested for security, it could breach and the user’s data can be stolen.

