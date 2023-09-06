package test.Execution;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import data.Testdata;
import pageObjects.Common_methods;
import pageObjects.crmUI_AddCategoryToExistingCompetition;
import pageObjects.encash_offers_signup_page_objects;





public class POC extends ObjectCreation {

				
	@Test(priority = 1)
	public void createCategory_AssignCompetition_DeleteCategory() throws Exception {
		
		System.out.println("createCategory_AssignCompetition_DeleteCategory");
		test = extent.createTest("createCategory_AssignCompetition_DeleteCategory");
		
		
		En_sign.crmUI_createNewCategory();
		crmui_addcategory.crmUI_AddCategoryToExisting_Competition();
		
		
		// Verify on common UI
		crmui_addcategory.stagingUrl_launch().encashUIVerifyCompetitionInCategory();
		
        //Delete category on Admin
		crmui_addcategory.crmUI_deleteCategory();
		
		
			}

	@Test//(priority = 3)
	public void Competition_Create_add_Questions() throws Exception {
		
		System.out.println("Competition_Create_add_Levels");
		test = extent.createTest("Competition_Create_add_Levels");
		
		CompetitionWeb.Competition_Create();
		
		CompetitionWeb.Competition_Questions().Competition_Level();
		

	}
	
	
	@Test//(priority = 4)
	public void User_Journey_Validations() throws Exception {
		Common_methods common = new Common_methods(driver);
		Testdata data = new Testdata();
//		Test_Live_Badge Live_Badge = new Test_Live_Badge(driver);
		test = extent.createTest("User_Journey_Validations");
		System.out.println("User_Journey_Validations");
		//String competationName = "testing123";
		crmui_addcategory.stagingUrl_launch();
		registration.register().registrationForm(data.NewRegistration);
		registration.SaveRegister();//.Consent();
		registration.skipemailverify();
		//not implemented as in the new framework
		
		common.searchCompetitionAndClick();
		common.playCompetition();
		common.mandatoryQuestion();
		crmui_addcategory.stagingUrl_logout();
//		common.mandatoryQuestion(data.mandatoryqueston());
//		common.competationQuestion(data.addquestion());
//		common.verifyCompetitions();
//		common.verifyThankyou();
//		// doing for next text case
		
		}
	


	@Test//(priority = 4)
	public void createClient_verifyInPrivacyPolicy_DisableClient() throws Exception {
		System.out.println("createClient_verifyInPrivacyPolicy_DisableClient");
		test = extent.createTest("createClient_verifyInPrivacyPolicy_DisableClient");
		
		// Create and enable client
		create_disable_client.crmUI_createClient_T15();		
				
		// Verify on common UI in privacy policy
		create_disable_client.encashUIVerifyClientInPrivacyPolicy();
		
		// Disable client
	    create_disable_client.crm_UI_disableClient_T15();
		
		//Verify non co-reg
		create_disable_client.encashUIVerifyClientInPrivacyPolicy_nonCoReg();
		  }
	
	@Test//(priority = 5)
	public void createClient_verify_newUser_disableClient() throws Exception {//fixed 29 jan 2021
		System.out.println("createClient_verify_newUser_disableClient");
		test = extent.createTest("createClient_verify_newUser_disableClient");
		
		// Create and enable client
		create_disable_client.crmUI_createClient_T15();		
		
		// Verify client for new user
		crmui_addcategory.stagingUrl_launch();
		NewUser_DisableClient.register();
		NewUser_DisableClient.encashUIVerifyClient_newUser();
		
        // Disable client
		create_disable_client.crm_UI_disableClient_T15();
   }
	@Test//(priority = 5)
	public void createClient_verify_returningUser_disableClient() throws Exception {//fixed 29 jan 2021
		System.out.println("createClient_verify_returningUser_disableClient");
		test = extent.createTest("createClient_verify_returningUser_disableClient");
		
		// Create and enable client
		create_disable_client.crmUI_createClient_T15();		
		
		
		// Verify client for new user
		ReturningUser_disableClient.encashUIVerifyClient_returningUser();
				
		// Disable client
	   create_disable_client.crm_UI_disableClient_T15();
  
	}
	
	@Test//(priority = 5)
	public void createOffer_verify_DisableOffer_newUser() throws Exception {
		System.out.println("createOffer_verify_DisableOffer_newUser");
		test = extent.createTest("createOffer_verify_DisableOffer_newUser");
		
		// Create and enable Offer
		DisableOffer_NewUser.crmUI_createOffer();
		
		// Add Questionnaire
		DisableOffer_NewUser.crmUI_AddQuestionsToOffer();
		
		// Disable offer
		DisableOffer_NewUser.crmUI_disableOffer();
		
	
}

	@Test//(priority = 7)
	public void createOffer_verify_DisableOffer_returningUser() throws Exception {
		
		System.out.println("createOffer_verify_DisableOffer_returningUser");
		test = extent.createTest("createOffer_verify_DisableOffer_returningUser");


        // Create and enable Offer	
		DisableOffer_NewUser.crmUI_createOffer();
		
	   // Add Questionnaire
	    DisableOffer_NewUser.crmUI_AddQuestionsToOffer();

    	// Verify on Encash UI
		crmui_addcategory.stagingUrl_launch().Userlogin();
		
		//registration.skipemailverify();
		DisableOffer_ReturningUser.encashUIVerifyOffer_returningUser();
		crmui_addcategory.stagingUrl_logout();
		
		// Verify My Offers
		crmui_addcategory.stagingUrl_launch().Userlogin();
		
		//registration.skipemailverify();
		DisableOffer_ReturningUser.encashUI_myOffers();
		crmui_addcategory.stagingUrl_logout();

		// Disable offer
		DisableOffer_NewUser.crmUI_disableOffer();
		
	
}
	
	// BEfore execute the senarion change the editname
	@Test//(priority = 9)
	public void createEditDelete_testimonials() throws Exception {

		System.out.println("createEditDelete_testimonials");
		test = extent.createTest("createEditDelete_testimonials");
		
		
		// Create New Testimonial
       	Testimonials.crmUI_createNewTestimonial();
		
		// Verify the testimonial in common Offers Page
		Testimonials.encashUIVerifyTestimonial().encashUIVerifyTestimonial();
		
		// Edit the above Testimonial
	    Testimonials.crmUI_editTestimonial();
	    
	    // Verify the edited testimonial in common Offers Page
	    Testimonials.encashUIVerifyEditedTestimonial();
	   
	    // Archive the testimonial with appending it with _OLD and disable it.
	    Testimonials.crmUI_editAndDisableTestimonial();
	
      }	
	@Test//(priority = 6) 
	public void VerifyEmail_with_Newly_Registred_user() throws Exception {
		System.out.println("Verify email with newly registred user");
		test = extent.createTest("Verify login newly registred User");	
		Testdata data = new Testdata();
	     String email_text=data.phoneForPasswordResetTest_mailVerify+"@mailinator.com";

		crmui_addcategory.stagingUrl_launch();
		Encash_t1_2.verifyRegister();
		registration.registrationForm1(data.NewRegistration);
		registration.SaveRegister();
		registration.skipemailverify();
		String Encashwindow = getCurrentWindow();
		OpenNewTab();
		launchMailinator();

		Encasht1_1.mailOpen(email_text);
		String ReadOTP = Encasht1_1.openMailReadOTP();
		String MailinatorWindow = getCurrentWindow();
		// switch to encashwindow
		setWindow(Encashwindow);
	//	Encasht1_1.emailOTP(ReadOTP);
		Thread.sleep(8000);
		crmui_addcategory.stagingUrl_logout();
		Thread.sleep(5000);
}  
	@Test//(priority = 7)
    public void Verify_New_Registration_By_click_on_NewHereRegister() throws Exception {
		System.out.println("Verify_New_Registration_By_click_on_NewHereRegister");
		test = extent.createTest("Verify_New_Registration_By_click_on_NewHereRegister");	
		Testdata data = new Testdata();
	      String email_text=data.phoneForNewHereRegisterTest+"@mailinator.com";

		crmui_addcategory.stagingUrl_launch();
		Encash_t1_2.verifyLoginRegister();
		registration.registrationForm2(data.NewRegistration);
		registration.SaveRegister();
		registration.skipemailverify();
		String Encashwindow = getCurrentWindow();
		OpenNewTab();
		launchMailinator();
		Encasht1_1.mailOpen(email_text);
		String ReadOTP = Encasht1_1.openMailReadOTP();
		String MailinatorWindow = getCurrentWindow();
		// switch to encashwindow
		setWindow(Encashwindow);
		Thread.sleep(8000);
		crmui_addcategory.stagingUrl_logout();
		Thread.sleep(5000);
	//	Encasht1_1.emailOTP(ReadOTP);
		
		}  	
	@Test//(priority = 8)
    public void Verify_New_User_Registration_By_Click_on_Participate_button() throws Exception {
		System.out.println("Verify_New_User_Registration_By_Click_on_Participate_button");
		test = extent.createTest("Verify_New_User_Registration_By_Click_on_Participate_button");	
		Testdata data = new Testdata();
	    String email_text=data.phoneForCompetitionTest+"@mailinator.com";

		crmui_addcategory.stagingUrl_launch();
		Encash_t1_2.competitionsLogin();
		registration.registrationForm3(data.NewRegistration);
		registration.SaveRegister();
		registration.skipemailverify();
		String Encashwindow = getCurrentWindow();
		OpenNewTab();
		launchMailinator();
		Encasht1_1.mailOpen(email_text);
		String ReadOTP = Encasht1_1.openMailReadOTP();
		String MailinatorWindow = getCurrentWindow();
		// switch to encashwindow
		setWindow(Encashwindow);
		Thread.sleep(8000);
		crmui_addcategory.stagingUrl_logout();
		Thread.sleep(5000);
		Thread.sleep(8000);
		crmui_addcategory.stagingUrl_logout();
		Thread.sleep(5000);
	//	Encasht1_1.emailOTP(ReadOTP);

}  	
	@Test//(priority = 9)
    public void Verify_New_User_Registration_By_Click_On_Offers_Button() throws Exception {
		System.out.println("Verify_New_User_Registration_By_Click_On_Offers_Button");
		test = extent.createTest("Verify_New_User_Registration_By_Click_On_Offers_Button");	
		Testdata data = new Testdata();
	    String email_text=data.phoneForOffersTest+"@mailinator.com";

		
		// click on offers tab and then select first offers
		crmui_addcategory.stagingUrl_launch();
		Encash_t1_2.offersLogin();
		registration.registrationForm_4(data.NewRegistration);		
		registration.SaveRegister();
		registration.skipemailverify();
		String Encashwindow = getCurrentWindow();
		OpenNewTab();
		launchMailinator();
		Encasht1_1.mailOpen(email_text);
		String ReadOTP = Encasht1_1.openMailReadOTP();
		String MailinatorWindow = getCurrentWindow();
		// switch to encashwindow
		setWindow(Encashwindow);
//		Encasht1_1.emailOTP(ReadOTP);

}  
	@Test//(priority = 10)
	public void Verify_New_User_Registration_By_Click_On_PlayNow_Button() throws Exception {
		System.out.println("Verify_New_User_Registration_By_Click_On_PlayNow_Button");
		test = extent.createTest("Verify_New_User_Registration_By_Click_On_PlayNow_Button");	
		Testdata data = new Testdata();
	    String email_text=data.phoneForPlayNowTest+"@mailinator.com";

		crmui_addcategory.stagingUrl_launch();
		Encash_t1_2.playLogin();
	     registration.registrationForm_5(data.NewRegistration);
		registration.SaveRegister();
		registration.skipemailverify();
		String Encashwindow = getCurrentWindow();
		OpenNewTab();
		launchMailinator();
		Encasht1_1.mailOpen(email_text);
		String ReadOTP = Encasht1_1.openMailReadOTP();
		String MailinatorWindow = getCurrentWindow();
		// switch to encashwindow
		setWindow(Encashwindow);
	//	Encasht1_1.emailOTP(ReadOTP);

}  
	@Test//(priority = 11)
	public void Postalcode_Test_New_User() throws Exception {
		System.out.println("Postalcode_Test_New_User");
		test = extent.createTest("Postalcode_Test_New_User");	
		Testdata data = new Testdata();
		
		// Register a new user
		
		Postalcode.registerNewUserForPostalCodeTest((data.NewRegistration));

	    // Enter postal code xx500x and verify if address and town text boxes are
		// displayed
		Postalcode.enterInvalidPostalCodeAndVerifyTextboxes();

		// Enter postal code KW14YT and verify if the address text box
		Postalcode.entervalidPostalCodeAndVerifyTextboxes();

		// Give consent to all clients and finish the new user registration
		Postalcode.giveConsent().clickContinueButton().skipemailverify();

		// Open edit profile dialog and verify postal code is set to KW14YT
		Postalcode.openEditProfileDialogAndVerifyPostalCode();
		
		// Make changes to postal code and verify the changes dont get saved upon
		// clicking cancel button
		Postalcode.modifyPostalCodeCancelAndVerifyChanges();

		// Make changes to postal code and save changes. Verify the changes are
		// reflected
		Postalcode.modifyPostalCodeSaveAndVerifyChanges();

	}
	
	//multiple Questions issue related to the UI
	@Test//(priority = 12)
	
	public void Test_high_response_options_dropdown() throws Exception {	
		System.out.println("test_high_response_options_dropdown");
		test = extent.createTest("test_high_response_options_dropdown");	
		Testdata data = new Testdata();
		
		// Login to commonoffers and search for automation competition1
		test_high_response.loginAndSearchForAutomationCompetition();
		
		// Participate in competition and verify the options are
		// > 8, options are in dropdown, the options are multiselection
		// verify the palceholder text
		test_high_response.participateAndVerifyNumberOfChoicesAndDropdown();
		
		
	     //	need to be done after fix the issue

		// Select few options, verify selection and move to next question
//		test_high_response.selectOptionsAndClickContinue();
//
		// Verify dropdown is shown for options >8 and the choices are single selection
//		test_high_response.verifyDropdownSingleChoiceOptions();
//
		// Verify options menu when number of options are equal to and less than 8
//		test_high_response.verifyOptionsMenu();   
//		
		
    }
	@Test//(priority = 13) //https://ssn-jira.atlassian.net/browse/common2-712
	
	public void test_live_badge() throws Exception {//fixed 3rd feb 2021
		 Testdata data = new Testdata();
		 System.out.println("Test_live_badge On CompetitionPage");
		 test = extent.createTest("Test_live_badge On CompetitionPage");
			
		// Login to commonoffers
		crmui_addcategory.stagingUrl_launch();
			
		// Search for particular Competition on the commonOffers Home page
	    Live_Badge.searchCompetition(data.competitionForLiveBadge);
			
		// Verify the live badge attributes
		Live_Badge.verify_live_badge();
			
		// Click and Verify the Live badge on the Competition Details page
		Live_Badge.verify_live_badgeOnCompetitionPage();
}      //note
	// note enter new number which is using enter in profile summary validations
	@Test//(priority = 14, enabled = true)
	public void Test_User_Registration_Dialog() throws Exception {

		Testdata data = new Testdata();
		System.out.println("Test_User_Registration_Dialog");
		test = extent.createTest("Test_User_Registration_Dialog");
		// Login to commonoffers
		crmui_addcategory.stagingUrl_launch();
		
		// Enter phone number and OTP
		registration.Test_User_Registration_Dialog_Register();
		
		// Verify all mandatory fields have *
		Test_user.verifyFieldsHaveMandatoryMarker();
	
    	// Verify all place holder texts
		Test_user.verifyPlaceHolderTexts();
		
		// Check if every field has error and invalid tag when left empty and continue
		// button is clicked
		Test_user.verifyFieldsHaveInvalidTag();
		
		// DOB filed validation
		Test_user.validateDOBField();
		
		// Validate password fields
		Test_user.validatePasswordFelds();
		
		// Validate display name field
		Test_user.validateDisplayNameField();

		// Validate consent checkbox
		Test_user.validateConsentCheckbox();

		// Validate email field
		Test_user.validateEmailText();

		// Cancel the registration and verify name in profile summary
		Test_user.validateProfileSummary();

		// Validate the profile details are empty
		Test_user.validateProfileDetails();

				
	}
	
	//assertTrue1(encashfeaturelist.equals(CRMadminfeatureoffers), "verify the offerfeature list are same");
   // offres not displayed in encash ui
	@Test//(priority = 15)
	public void Createfeaturedoffers_Verify_FeaturedOffers() throws Exception {
		  Common_methods common = new Common_methods(driver);
			Testdata testdata = new Testdata();
			
		System.out.println("Createfeaturedoffers_Verify_FeaturedOffers");
		test = extent.createTest("Createfeaturedoffers_Verify_FeaturedOffers");
	
		
		featured_offers.allOffersFeatures();
		List<String> crmadminfeaturename =common.getOfferFeaturelist();
		//in new tabl open the encash offers page
		String CRMadmin = getCurrentWindow();
		common.OpenNewTab();
		crmui_addcategory.stagingUrl_launch();
		common.verifyFeatureoffer(crmadminfeaturename);
		String Encash = getCurrentWindow();
		setWindow(CRMadmin);
		// create the new featuredoffers
		common.createFeaturedOffers(testdata.featuredoffersCreatename);

		// empty the previous featurename
		crmadminfeaturename.clear();
		// get the featured name once again
		crmadminfeaturename = common.getOfferFeaturelist();
		// switch to encash page and reload it
		setWindow(Encash);
		String stagingUrl= rconfig.getstagingUrl();
		driver.get(stagingUrl);
		Thread.sleep(5000);
		// reload the page
		reloadpage();
		Thread.sleep(5000);
		common.verifyFeatureoffer(crmadminfeaturename);
		// Change the position of new created featured offers
		setWindow(CRMadmin);
		common.dragDropFeturedoffers(testdata.featuredoffersCreatename, testdata.featuredoffersdropname);
		//empty the previous featurename 
		crmadminfeaturename.clear();
		//get the featured name once again
		crmadminfeaturename = common.getOfferFeaturelist();
		//switch to encash page and reload it
		setWindow(Encash);String stagingUrl1= rconfig.getstagingUrl();
		driver.get(stagingUrl1);
		Thread.sleep(5000);
		// reload the page
		reloadpage();
		common.verifyFeatureoffer(crmadminfeaturename);

		setWindow(CRMadmin);
		//delete the created featured offers
		common.deleteFeatureOffers(testdata.featuredoffersCreatename);


	}
	
	//assertTrue1(encashfeaturelist.equals(CRMadminfeatureoffers), "verify the offerfeature list are same");
	   // offres not displayed in encash ui
	
	@Test//(priority = 16)//https://ssn-jira.atlassian.net/browse/ENCASH2-638
	public void CreateEditFeaturedCompetitions() throws Exception {//fixed 3rd feb 2021
		encash_offers_signup_page_objects En_sign = new encash_offers_signup_page_objects(driver);

		System.out.println("CreateEditFeaturedCompetitions");
		test = extent.createTest("CreateEditFeaturedCompetitions");
	    Testdata data = new Testdata();
			
		
		
		// Create a featured competition on Admin
	    createEditFeatured.crmUI_createNewFeaturedCompetition();
		@SuppressWarnings("unchecked")
		List<String> crmadminfeaturename = createEditFeatured.getFeaturedCompetitionslist();

		// Verify on Encash UI - Top competitions, Competitions tab, featured tag
		createEditFeatured.verifyFeatureCompetitions(crmadminfeaturename);

		// Reorder the created competition
		createEditFeatured.crmUI_dragDropFeaturedCompetition(data.CRMFeaturedComp, data.destComp);

		// Verify on Encash UI - Top competitions, Competitions tab
		crmadminfeaturename.clear();
	    crmadminfeaturename = createEditFeatured.getFeaturedCompetitionslist();
	    En_sign.Admin_logout();
	    createEditFeatured.verifyFeatureCompetitions(crmadminfeaturename);

		// Remove the competition from Admin
	    createEditFeatured.crmUI_deleteFeaturedCompetition();

		// Verify deletion
	    createEditFeatured.encashUI_verifyDeletionOfFeaturedCompetition();
		
	}
			

	@Test//(priority = 17)//https://ssn-jira.atlassian.net/browse/common2-646
	public void Test_Common_UI_Password_Reset_Functionality() throws Exception {//fixed 19th feb 2021
		
		System.out.println("Test_Common_UI_Password_Reset_Functionality");
		test = extent.createTest("Test_Common_UI_Password_Reset_Functionality");
		
	   
	 // Launch and navigate to userprofile
	    Password_Reset.launchAndNavigateToUserProfile();

	 		// Check if verify button is disabled in 'Verify Password' dialog
	    Password_Reset.checkVerifyButtonIsDisabled();

	 		// Enter a wrong password and check if error message and red border is displayed
	 		// for new password text box
	    Password_Reset.newPasswordTextBoxWrongPasswordTest();

	 		// Enter a mismatching password in confirm password textbox and verify error
	 		// message and red border for the text box
	    Password_Reset.confirmPasswordTextBoxMismatchingPasswordTest();

	 		// Enter valid password in both text boxes and verify no error messages or red
	 		// border is displayed
	    Password_Reset.enterNewPasswordsAndVerify();

	 		// Close the dialog and verify password is not changed
	    Password_Reset.closePasswordResetDialogAndCheckPasswordNotChanged();
	    
	 		// Change to new password and verify password is changed
	    Password_Reset.resetToNewPasswordAndVerifyPasswordIsChanged();

	 	} 
	

	@Test//(priority = 18)
	public void Test_Description_For_Questions() throws Exception {
	    Testdata data = new Testdata();

		System.out.println("Test_Description_For_Questions");
		test = extent.createTest("Test_Description_For_Questions");
        String questionForEditDescription = "What is your current employment status?";
	    String originalQuestionDescription	= "Your right to privacy is very important to us and we "
	    		+ "take the security of your information seriously.";


		// Set the Description to the desired for the Question 3
        Test_Description.crmUI_setQuestionDescription(questionForEditDescription, originalQuestionDescription);

		// Register a new user
        Test_Description.registerNewUserForDescritionTest(data.phoneForDescriptionTest, data.otpForDescriptionTest,
	    		data.phoneForDescriptionTest + "@mailinator.com");
	    Test_Description.searchCompetitionAndClick(data.competitionForDescription);
	    Test_Description.playCompetitionForDesc();
	    Test_Description.verifyDescription("original");

		// Login to Admin Application and Edit the Question
	    Test_Description.crmUI_setQuestionDescription(data.questionForEditDescription, data.editedQuestionDescription);

		// Register a new user and participate in same competition to check whether the
		// edited Description for Question 3 is reflected or not.
	    Test_Description.registerNewUserForDescritionTest(data.phoneForDescriptionTest_2, data.otpForDescriptionTest_2,
				data.phoneForDescriptionTest_2 + "@mailinator.com");
	    Test_Description.searchCompetitionAndClick(data.competitionForDescription);
	    Test_Description.playCompetitionForDesc();
	    Test_Description.verifyDescription("edited");

		// Revert the edited changes for Question 3 back to Original Description      
	    Test_Description.crmUI_setQuestionDescription(data.originalQuestionDescription,data.questionForEditDescription );
	}  

	@Test// (priority = 19, enabled = true)//https://ssn-jira.atlassian.net/browse/common2-646
	public void Forgot_Password_Test() throws Exception {
		Common_methods common = new Common_methods(driver);
		
		System.out.println("Forgot_Password_Test");
		test = extent.createTest("Forgot_Password_Test");
		
		//Click on login and navigate to forgot password
		forget_PW.launchAndClickOnForgotPassword();

		//Enter phone number and OTP
		forget_PW.enterPasswordAndOTP();

		//Enter new password
		forget_PW.enterNewPasswordAndVerifySuccessMessage();

		//Logout and Login with new password to confirm password change
		forget_PW.loginWithNewPasswordVerifyPasswordReset();

	}
	
	
	

	/**
	 * author - vinod
	 * 
	 * For testcase ID :- common2-T13 This test verify the Topoffers and
	 * compare both in CRMadmin and common
	 * 
	 * @throws Exception
	 */

	@Test//(priority = 20)//https://ssn-jira.atlassian.net/browse/common2-663
	public void Create_TopOffers_Verify_TopOOffers() throws Exception {
		
        Common_methods common = new Common_methods(driver);
		
		System.out.println("Create_TopOffers_Verify_TopOOffers");
		test = extent.createTest("Create_TopOffers_Verify_TopOOffers");
		Testdata testdata = new Testdata();
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		// launch encash offers
		
		
		top.topOffers();
		List<String> crmadminfeaturename =common.getOfferFeaturelist();
		List<String> crmadmintopfeaturename = top.removetopofferslist(crmadminfeaturename);
		//in new tabl open the common offers page
		String CRMadmin = getCurrentWindow();
		common.OpenNewTab();
		crmui_addcategory.stagingUrl_launch();
		
		top.verifyTopoffer(crmadmintopfeaturename);

		String Encash = getCurrentWindow();
		setWindow(CRMadmin);
		//create the new featuredoffers
		top.createTopOffers(testdata.TopOffersCreatename);

		//empty the previous featurename 
		crmadminfeaturename.clear();
		crmadmintopfeaturename.clear();
		//switch to encash page and reload it
		setWindow(CRMadmin);
		//reload the page
		reloadpage();
		Thread.sleep(15000);
		//get the featured name once again
		crmadminfeaturename = top.getOfferFeaturelist();
		reloadpage();
		Thread.sleep(15000);
		crmadmintopfeaturename = top.removetopofferslist(crmadminfeaturename);
		//switch to common page and reload it
		setWindow(Encash);
		//reload the page
		reloadpage();
		top.verifyTopoffer(crmadmintopfeaturename);
		//Change the position of new created featured offers
		setWindow(CRMadmin);
		top.dragDropTopoffers(testdata.TopOffersCreatename, testdata.TopOffersdropname);
		//empty the previous featurename 
		crmadminfeaturename.clear();
		crmadmintopfeaturename.clear();
		//get the featured name once again
		reloadpage();
		Thread.sleep(15000);
		crmadminfeaturename = top.getOfferFeaturelist();
		crmadmintopfeaturename = top.removetopofferslist(crmadminfeaturename);
		//switch to common page and reload it
		setWindow(Encash);
		//reload the page
		reloadpage();
		top.verifyTopoffer(crmadmintopfeaturename);

		setWindow(CRMadmin);
		//delete the created featured offers
		top.deleteTopOffers(testdata.TopOffersCreatename);

	}
	
	/*
	 * Check ENCASH2-T9 for more details
	 * 
	 * @throws Exception
	 */
// Reports dropdoown not working in domain
	@Test//(priority = 21)//https://ssn-jira.atlassian.net/browse/ENCASH2-380
	public void Verify_Crm_Admin_TitlesList() throws Exception {//fixed 02 feb 2021 as per UI changes
		System.out.println("Verify_Crm_Admin_TitlesList");
		test = extent.createTest("Verify_Crm_Admin_TitlesList");
		Testdata testdata = new Testdata();
		top.crmUI_application_list();
	}
	
	
	/**
	 * author - vinod
	 * 
	 * This method is used to check for creation of competition, 
	 * edit the competition and verify competition in Encash offers
	 * 
	 * Already one TestCompetition has been created for testing 
	 * "Test_Competition"
	 * 
	 *  Check ENCASH2-T53
	 * @throws Exception 
	 */

	@Test//(priority = 22)//https://ssn-jira.atlassian.net/browse/ENCASH2-717
	public void Crm_CompetationEdit_Validations() throws Exception {
		System.out.println("crm_CompetationEdit");
		test = extent.createTest("crm_CompetationEdit");
		Testdata data = new Testdata();
		  Common_methods common = new Common_methods(driver);
		//Crm_CompetationEdit

	
		
		crm.SearchCompetition("Test_Competition");
		crm.EditCompetition(data.EditCompetitiondata());
		crm.SearchCompetition(data.EditCompetitiondata().get("Name"));
		crm.editCompetitionQuestion(data.competitionEdit,data.competitionEditSelect);
		//Search the competition open for edit
		crm.SearchCompetition(data.EditCompetitiondata().get("Name"));
		crm.verifyEditcompetitionBasic(data.EditCompetitiondata());

		//login to encash and take one competition 
		crmui_addcategory.stagingUrl_launch();
		crmui_addcategory.Userlogin();
//		registration.register();
//		registration.registrationForm(data.NewRegistration);
//		registration.Consent();
//		registration.SaveRegister();
//		registration.skipemailverify();
		crm.searchCompetitionAndClick(data.EditCompetitiondata().get("Name"));
//		crm.playCompetition(); 
//		crm.SurveyQuestion(data.MandatoryQuestion());
//		crm.competationQuestion(data.surveyquestion());
		// **/

		//revert back the edit competition 
		//Search the competition open for edit
		crm.SearchCompetition(data.EditCompetitiondata().get("Name"));
		crm.EditCompetition(data.OriginalCompetitiondata());
		crm.SearchCompetition(data.OriginalCompetitiondata().get("Name"));
		crm.editCompetitionQuestion(data.competitionoriginal,data.competitionoriginalSelect);
		En_sign.Admin_logout();

	}

	@Test//(priority = 23) //https://ssn-jira.atlassian.net/browse/ENCASH2-637
	public void CreateCategory_AssignOffer_DeleteCategory() throws Exception {
		System.out.println("CreateCategory_AssignOffer_DeleteCategory");
		test = extent.createTest("CreateCategory_AssignOffer_DeleteCategory");
		Testdata data = new Testdata();
		

		// Create category on Admin
	//	  CreateCategory.crmUI_createNewCategory();
		
		  CreateCategory.crmUI_AddCategoryToExistingOffer();

		// Verify on Encash UI
		  CreateCategory.encashUIVerifyOfferInCategory();

		// Delete category on Admin
	//	  CreateCategory.crmUI_deleteCategory();

	}
	// automation not completed
	@Test//(priority = 24)//https://ssn-jira.atlassian.net/browse/ENCASH2-663
	public void Verify_TopCompetition() throws Exception {
		System.out.println("Verify_TopCompetition");
		test = extent.createTest("Verify_TopCompetition");
		
		  Common_methods common = new Common_methods(driver);

		Testdata testdata = new Testdata();

		topCompetitions.topCompetitions();
		List<String> crmadminfeaturename =top.getOfferFeaturelist();
		Thread.sleep(5000);
		List<String> crmadmintopfeaturename = topCompetitions.removetopCompetitionlist(crmadminfeaturename);
		//in new tabl open the encash offers page
		String CRMadmin = getCurrentWindow();
		common.OpenNewTab();
		crmui_addcategory.stagingUrl_launch();
		topCompetitions.verifyTopCompetition(crmadmintopfeaturename);

		String Encash = getCurrentWindow();
		setWindow(CRMadmin);
		//create the new featured Competitions
		topCompetitions.createTopCompetition(testdata.TopCompetitionsCreatename);

		//empty the previous featurename 
		Thread.sleep(3000);
		crmadminfeaturename.clear();
		crmadmintopfeaturename.clear();
		reloadpage();
		Thread.sleep(15000);
		//get the featured name once again
		crmadminfeaturename = top.getOfferFeaturelist();
		crmadmintopfeaturename = topCompetitions.removetopCompetitionlist(crmadminfeaturename);
		//switch to encash page and reload it
		setWindow(Encash);
		//reload the page
		reloadpage();
		topCompetitions.verifyTopCompetition(crmadmintopfeaturename);
		//Change the position of new created featured competitions
		setWindow(CRMadmin);

		Thread.sleep(3000);
//		topCompetitions.dragDropTopCompetitions(testdata.TopCompetitionsCreatename, testdata.TopCompetitiondropname);
		//empty the previous featurename 
		crmadminfeaturename.clear();
		crmadmintopfeaturename.clear();
		reloadpage();
		Thread.sleep(15000);
		//get the featured name once again
		crmadminfeaturename = top.getOfferFeaturelist();
		crmadmintopfeaturename = topCompetitions.removetopCompetitionlist(crmadminfeaturename);
		//switch to encash page and reload it
		setWindow(Encash);
		//reload the page
		reloadpage();
		topCompetitions.verifyTopCompetition(crmadmintopfeaturename);

		setWindow(CRMadmin);

		//delete the created featured offers		
		Thread.sleep(3000);
		topCompetitions.deleteTopCompetition(testdata.TopCompetitionsCreatename);

	}
	@Test//(priority = 25)
	public void Create_Edit_Disable_TenancyOffer() throws Exception {

		Testdata data = new Testdata();

		System.out.println("Create_Edit_Disable_TenancyOffer");
		test = extent.createTest("Create_Edit_Disable_TenancyOffer");
		
		// Create and enable Offer
		Tenancy_offer.crmUI_createTenancyOffer();

		// Verify on Encash UI
		Tenancy_offer.encashUIVerify_tenancyOffer("original");

		//Edit the Tenancy Offer
		Tenancy_offer.crmUI_editTenancyOffer();

		// Verify on Encash UI
		Tenancy_offer.encashUIVerify_tenancyOffer("edited");

		// Disable offer
		Tenancy_offer.crmUI_disableOffer("Edited"+data.CRMTenancyOfferName+"Edited");

	}
	
	
	@Test//(priority = 26)
	public void consumerRedirectionToOffersPage_Test1() throws Exception {
		System.out.println("consumerRedirectionToOffersPage_Test1");
		test = extent.createTest("consumerRedirectionToOffersPage_Test1");
		Common_methods common = new Common_methods(driver);
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
			//crmui_addcategory.stagingUrl_launch();
			Testdata data = new Testdata();


		
		//Login to encashoffers
		//Usecase1
	   ConsumerRedirection.loginAndParticipateInAutomationCompetition(data.competitionForUserRedirectionTest2, data.emailForOfferPageRedirection1);
	   
	   	       ConsumerRedirection.selectOptionsAndClickContinue();
			   ConsumerRedirection.answerSurveryQuestion();
			   ConsumerRedirection.verifyContinueDialog();
			   ConsumerRedirection.waitOnThankYouModalAndVerifyRedirection();
			//   crmui_addcategory.stagingUrl_logout();
					
//				//Usecase2
//				ConsumerRedirection.loginAndParticipateInAutomationCompetition(data.competitionForUserRedirectionTest2,
//			 data.emailForOfferPageRedirection1);
//				test_high_response.selectOptionsAndClickContinue();
//				ConsumerRedirection.answerSurveryQuestion();
//				ConsumerRedirection.verifyContinueDialog();
//				ConsumerRedirection.clickDoneOnThankYouModalDialogAndVerifyRedirection();
			}

	
	/**
	 * author - raghu
	 * https://ssn-jira.atlassian.net/browse/ENCASH2-600
	 * https://ssn-jira.atlassian.net/browse/ENCASH2-731
	 * Check  Encash2-T58 for more details 
	 * Requires a registered phone number
	 * 	
	 */
	@Test//(priority = 27)
	public void consumerRedirectionToOffersPage_Test2() throws Exception {
		//Login to encashoffers
		
		System.out.println("consumerRedirectionToOffersPage_Test2");
		test = extent.createTest("consumerRedirectionToOffersPage_Test2");
		//Usercase3

	}
	
	@Test//(priority = 28)
	public void VerifyPostback() throws Exception {
		
		System.out.println("VerifyPostback");
		test = extent.createTest("VerifyPostback");
		Common_methods common = new Common_methods(driver);
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
			
		Testdata data = new Testdata();
	    String affiliateURL = "http://staging.encashoffers.com/competitions/details/automation-competition-for-pixel-tracking/603726ae7e5fe67038f86d1c?aid=5f4f720fe72f3129fd820a70&sid=5f45f46b7e5fe6184fd9b9cb&utm_source=stewart_test&utm_medium=affiliate&utm_campaign=automation_competition_for_pixel_tracking&xyz=12User"+data.phone+"Aut";
		String clickId = "12User"+data.phone+"Aut";

		crmui_addcategory.stagingUrl_launch();

		//Land into the competition with the the URL configured for the Competition.
		driver.get(affiliateURL);
		postback.playCompetitionForDesc();

		// Register a new user
		postback.registerNewUserForPostback();

		//Answer Mandatory Question
//		postback.playAutomationPostbackComp();

		//Open New window
		common.OpenNewTab();
		//Verify the Conversion Count in the Traffic Report.
		postback.crmUI_checkConversionCount(data.phone, clickId);			
	}
	@Test//(priority = 29, dependsOnMethods = { "verifyPostback" })
	public void verifyTenancyEmail() throws Exception {

		System.out.println("verifyTenancyEmail");
		test = extent.createTest("verifyTenancyEmail");
		Common_methods common = new Common_methods(driver);
		Testdata data = new Testdata();
		
		//Launch Mailinator and open mail
		common.launchMailinator();
		common.mailOpen(data.phone + "@mailinator.com");

		//Verify the Registration Mail
		email.openMailVerifyTenancyOffers2("registrationMail");

		//Verify the Offer Mail
		email.openMailVerifyTenancyOffers("offerMail");			
	}
	
	
	@Test//(priority = 4)
	public void YBC_User_Journey_Validations() throws Exception {
		Common_methods common = new Common_methods(driver);
		Testdata data = new Testdata();
//		Test_Live_Badge Live_Badge = new Test_Live_Badge(driver);
		test = extent.createTest("User_Journey_Validations");
		System.out.println("User_Journey_Validations");
		//String competationName = "testing123";
		crmui_addcategory.stagingUrl_launch();
		registration.register().registrationForm(data.NewRegistration);
		registration.SaveRegister();//.Consent();
		registration.skipemailverify();
		//not implemented as in the new framework
		
		common.searchCompetitionAndClick();
		common.playCompetition();
		common.mandatoryQuestion2();
		sign_up1.Verify_the_EO_User_YBC_Journey();
	}
	
	@Test()//(dataProvider = "excel")
	public void OrganicUserHomePage_Pick_You_Appliance_Validations() throws InterruptedException, IOException {
		System.out.println("HomePage_Pick_You_Appliance_Validations");
		test = extent.createTest("HomePage_Pick_You_Appliance_Validations");
		sign_up1.YBC_LandingPage_validations().Pick_You_Appliance_validations();
		
	}
	
	@Test()
	public void Select_applience_validations() throws InterruptedException, IOException {
		System.out.println("Select_applience_validations");
		test = extent.createTest("Select_applience_validations");
	//	sign_up1.YBC_LandingPage_validations().Pick_You_Appliance_validations();
		ysp.Select_Applience();
		
}
	
	@Test()
	public void Quote_Summary_validations() throws InterruptedException, IOException {
		System.out.println("Quote_Summary_validations");
		test = extent.createTest("Quote_Summary_validations");
//		sign_up1.YBC_LandingPage_validations().Pick_You_Appliance_validations();
//		ysp.Select_Applience();
		Quote.Quotesummary();

	
	}
	
	  @Test()
	    public void Customer_Information_validations() throws Exception {
		System.out.println("Customer_Information_validations");
		test = extent.createTest("Customer_Information_validations");
//		sign_up1.YBC_LandingPage_validations().Pick_You_Appliance_validations();
//		ysp.Select_Applience();
//		Quote.Quotesummary();
		CI.verifyFieldsHaveMandatoryMarker().CI_Validate_Placeholders_Fields().verifyFieldsHaveInvalidTag();
		CI.CI_Validation_Message_Fields().Validate_the_postalcode();
       }
	
	   @Test()
		public void Bank_DetailsPage_Validations() throws Exception {
		System.out.println("Bank_DetailsPage_Validations");
		test = extent.createTest("Bank_DetailsPage_Validations");
//		sign_up1.Encash_home_validations().Pick_You_Appliance_validations();
//		ysp.Select_Applience();
//		Quote.Quotesummary();
//		CI.verifyFieldsHaveMandatoryMarker().verifyFieldsHaveInvalidTag();
//		CI.CI_Validation_Message_Fields().CI_Validate_Placeholders_Fields().Validate_the_postalcode();
		bank.fields_Validations_Message().verifyFieldsHaveInvalidTag().Bank_Details_Validate_Placeholders_Fields();
		bank.verifyFieldsHave_MandatoryTag().Validate_Bankname_Field_InvalidData().Validate_Bankname_Field_validData();
		bank.Bank_Date_Available_Validations_Message().Submit_concent_Terms();
				
		}
		@Test()
		public void Confirm_Bank_DetailsPage_Validations() throws Exception {
		System.out.println("Confirm_Bank_DetailsPage_Validations");
		test = extent.createTest("Confirm_Bank_DetailsPage_Validations");
//		sign_up1.Encash_home_validations().Pick_You_Appliance_validations();
//		ysp.Select_Applience();
//		Quote.Quotesummary();
//		CI.verifyFieldsHaveMandatoryMarker().verifyFieldsHaveInvalidTag();
//		CI.CI_Validation_Message_Fields().CI_Validate_Placeholders_Fields().Validate_the_postalcode();
//		bank.fields_Validations_Message().verifyFieldsHaveInvalidTag().Bank_Details_Validate_Placeholders_Fields();
//		bank.verifyFieldsHave_MandatoryTag().Validate_Bankname_Field_InvalidData().Validate_Bankname_Field_validData();
//		bank.Bank_Date_Available_Validations_Message().Submit_concent_Terms();
		Confirm_Bank.Bank_details_validation().Payment_Confirmation();
		
				
		}
		@Test()
		public void Thank_You_SocialMedia_Page_Validations() throws Exception {
			System.out.println("Thank_You_SocialMedia_Page_Validations");
			test = extent.createTest("Thank_You_SocialMedia_Page_Validations");
//			sign_up1.Encash_home_validations().Pick_You_Appliance_validations();
//			ysp.Select_Applience();
//			Quote.Quotesummary();
//			CI.verifyFieldsHaveMandatoryMarker().verifyFieldsHaveInvalidTag();
//			CI.CI_Validation_Message_Fields().CI_Validate_Placeholders_Fields().Validate_the_postalcode();
//			bank.fields_Validations_Message().verifyFieldsHaveInvalidTag().Bank_Details_Validate_Placeholders_Fields();
//			bank.verifyFieldsHave_MandatoryTag().Validate_Bankname_Field_InvalidData().Validate_Bankname_Field_validData();
//			bank.Bank_Date_Available_Validations_Message().Submit_concent_Terms();
//			Confirm_Bank.Bank_details_validation().Payment_Confirmation();
			Thank_you.Thank_You_page_Validations().Irresistible_offer_alert();
            Thank_you.Verify_EO_Landing().Verify_EO_UserScorePoints();

		
		}	
         //EncashOffer User playing the Competition And Logged in YBC Scenarios
		
		@Test()//(dataProvider = "excel")
		public void EO_UserHomePage_Pick_You_Appliance_Validations() throws InterruptedException, IOException {
			System.out.println("EO_UserHomePage_Pick_You_Appliance_Validations");
			test = extent.createTest("EO_UserHomePage_Pick_You_Appliance_Validations");
			sign_up1.YBC_LandingPage_validations_EO().Pick_You_Appliance_validations();
			
		}
		
//		Organic User search Appliance functionality of YES Radio Button
	
		@Test()//(dataProvider = "excel")
		public void Organic_User_Pick_You_Appliance_Search_NO_Radio_Button_Functionality() throws Exception {
			System.out.println("Organic_User_Pick_You_Appliance_Search_YES_Radio_Button_Functionality");
			test = extent.createTest("Organic_User_Pick_You_Appliance_Search_YES_Radio_Button_Functionality");
			sign_up1.YBC_LandingPage_validations_newtab_appliance_NO();
		
		}
//		Organic User search Appliance functionality of NO Radio Button
		
		@Test()//(dataProvider = "excel")
		public void Organic_User_Pick_You_Appliance_Search_YES_Radio_Button_Functionality() throws InterruptedException, IOException {
			System.out.println("Organic_User_Pick_You_Appliance_Search_NO_Radio_Button_Functionality");
			test = extent.createTest("Organic_User_Pick_You_Appliance_Search_NO_Radio_Button_Functionality");
			sign_up1.YBC_LandingPage_validations_newtab_appliance_YES();
		}
		
//		Organic User Declaration functionality of YES Radio Button after click on NO radio on Quote summary window
		@Test()//(dataProvider = "excel")
		public void Organic_User_Declaration_YES_Radio_Button_Functionality() throws Exception {
			System.out.println("Organic_User_Declaration_YES_Radio_Button_Functionality");
			test = extent.createTest("Organic_User_Declaration_YES_Radio_Button_Functionality");
	        waitTime();
			sign_up1.YBC_LandingPage_validations_Dec_yes();
			
			
		}	

//		Organic User Declaration functionality of NO Radio Button after click on NO radio on Quote summary window
		@Test()//(dataProvider = "excel")
		public void Organic_User_Declaration_NO_Radio_Button_Functionality() throws Exception {
			System.out.println("Organic_User_Declaration_NO_Radio_Button_Functionality");
			test = extent.createTest("Organic_User_Declaration_NO_Radio_Button_Functionality");
			
			sign_up1.YBC_LandingPage_validations_Dec_no();
			
		}	
		
		@Test()
		public void Customer_information_Without_Enter_mobile_number() throws Exception {
			System.out.println("Customer_information_Without_Enter_mobile_number");
			test = extent.createTest("Customer_information_Without_Enter_mobile_number");
//			sign_up1.Ybc_sign_in_newtab2();
			sign_up1.verify_the_reg_num_validations_on_EO_reg();
			
}	
		
		@Test()
		public void Verify_Signup_Details_ByDefault_On_EO_Signup_Page() throws Exception {
			System.out.println("Verify_Signup_Details_ByDefault_On_EO_Signup_Page");
			test = extent.createTest("Verify_Signup_Details_ByDefault_On_EO_Signup_Page");
			sign_up1.verify_the_reg_num_validations_on_EO_new();
			
}	

		
		
}

