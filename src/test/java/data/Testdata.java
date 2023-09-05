package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Testdata {
	//common data
 //	YBC_C.I text data
	public String password="tester123";
	public String FirstName1="Pasupuleti";
	public String lastName1="kumar";
	public String phone1="2345678963";
	public String New_phone="2312345681";
	public String Postalcode1="tester123";
	public String Postalcode2="M11AE";
	public String Email1="kumar33@mailinator.com";
	public String competationName="OnePlus Phone";
	public String competationName_t="Color Pencil";
	public String competationName_t1="Sketch Color";
//	YBC_Bank_Details text data for validation
	public String Account_Number="abc";
	public String Account_Name="12345";
	public String ShortCode="1234";

//	YBC_Bank_Details text Invalid_data for validation
	public String Account_Number2="70872491";
	public String Account_Name2="kumar2";
	public String ShortCode2="404784";
	
//	YBC_Bank_Details text data for validation
	public String Account_Number1="70872490";
	public String Account_Number3="55779933";
	public String Account_Name1="kumar2";
	public String Account_Name3="kumar";
	public String ShortCode1="404784";
	public String ShortCode3="200000";
	public String Bank_Name="HSBC UK BANK PLC - Leeds";
	public String Bank_Name3="BARCLAYS BANK PLC - Leicester";

	//public String password="tester123";
	public String lastName="Doe";
	public String xx500x="xx 500x";
	public String kw14yt="kw1 4yt";
	public String postal_code_3="";
	public String addressLine1="1 Breck Cottages";
	public String town_city="Wick";
	//Encash UI
	public String expLogo;
	public String email;
	public String pwd;
	public String phone;
	public String otp;
	public List<String> expMsgs=new LinkedList<String>();
	public String expCompetitionsLink;
	public String expOffersLink;
	public String expHowitworksLink;
	public String expTxtOnScreen;
	public List<String> expTitles=new LinkedList<String>();
	public HashMap<String,String> NewRegistration = new HashMap<String,String>();
	public HashMap<String, String> NewUserRegistrationForPostalCode = new HashMap<String, String>();
	public String returningUserEmail;
	public String returningUserPwd;
	public String displayName;
	public String competitionForLiveBadge;
	//Postal code test related
	public String phoneForPostalCodeTest;
	public String phoneForForgetPW;
	public String otpForPostalCodeTest;
	public String emailForPostalCodeTest;
	public String firstName;
	//User password reset test
	public String phoneForPasswordResetTest_mailVerify;
	public String phoneForNewHereRegisterTest;
	public String phoneForCompetitionTest;
	public String phoneForOffersTest;
	public String phoneForPlayNowTest;
	public String PhoneForPostalcode;
	public String PhoneForTestUserRegistration;
	//High response options dropdown related
	public String competitionForHighResponseOptionsTest; 
	//Registration dialog related
	public String phoneForRegistrationFormTest;
	//Mandatory Questions Description related
	public String phoneForDescriptionTest;
	public String otpForDescriptionTest;
	public String phoneForDescriptionTest_2;
	public String otpForDescriptionTest_2;	
	public String competitionForDescription;
	public String questionForEditDescription;
	public String originalQuestionDescription;
	public String editedQuestionDescription;
	public String competitionEdit = "TestingScenario";
	public String competitionEditSelect = "TestingScenario (1 segments)";
	public String competitionoriginal = "Consumer Questions";
	public String competitionoriginalSelect = "Consumer Questions (1 segments)";
	public String CRM_existingOfferName;
	public String CRM_categoryForOffer;
	public String phoneForOfferPageRedirection1;
	public String phoneForOfferPageRedirection2;
	public String emailForOfferPageRedirection1;
	public String emailForOfferPageRedirection2;
	public String competitionForUserRedirectionTest2;
	public String competitionForUserRedirectionTest3;
	public String competitionForUserRedirectionTest4;
	public String competitionForUserRedirectionTest5;
	public String competitionForPostback;
	
	/**
	 * Title field in user 
	 * registration dialog
	 * 
	 */
	public enum TITLE {
		Mr,
		Mrs,
		Ms;
	}
	/**
	 * 
	 * Gender field in user 
	 * registration dialog
	 *
	 */
	public enum GENDER {
		MALE, FEMALE;
	}


	//CRM [Admin]
	public String location;
	public String CRMClientName;
	public String CRMCategoryName;
	public String CRMCompetitionName;
	public String CRM_clientForCompetition;
	public String CRM_categoryForCompetition;
	public String CRM_endDate;
	public String CRM_existingCompetitionName;
	public String CRM_categoryForClient;
	public String CRMClientDesc;
	public String CRMClientprivacyPolicy;
	public String CRMFullClientDesc;
	public String CRMOfferName;
	public String CRMOfferDesc;
	public String CRMClientForOffer;
	public String CRMCategoryForOffer;
	public String CRMOfferQuestion1;
	public String CRMOfferQuestion2;
	public String CRMConsumerName;
	public String CRMTestimonial;
	public String CRMFeaturedComp;
	public String featured;
	public String destComp;
	public String TopOffersCreatename;
	public String TopOffersdropname;
	public String featuredoffersCreatename;
	public String featuredoffersdropname;
	public String TopCompetitionsCreatename;
	public String TopCompetitiondropname;
	public String CRMTenancyOfferName;
	public String CRMTenancyOfferDesc;
	public String CRMTenancyOfferTransferURL;
	public String CRMTenancyOfferTransferURL_edited;
	public String expectedHeading;
	public String TenancyOffer1;
	public String TenancyOffer2;
	public String expectedURLForTenancyOffer1;
	public String expectedURLForTenancyOffer2;
	public String expectedURL_Click_Here;
	
	

	public Testdata() {	

		expLogo="Encash Offers Logo";

		email="gmail@gmail.com";
		pwd="password123";
		phone="7700185193";
		otp="123456";

		//User redirection to offer page
		phoneForOfferPageRedirection1 = "2345678917";
		phoneForOfferPageRedirection2 = "2345678912";
		emailForOfferPageRedirection1 = phoneForOfferPageRedirection1+"@mailinator.com";
		emailForOfferPageRedirection2 = phoneForOfferPageRedirection2+"@mailinator.com";
		competitionForUserRedirectionTest2 = "Automation Competition 4B1";
	//	competitionForUserRedirectionTest2 = "XBOX";
		competitionForUserRedirectionTest3 = "Automation Competition 3";
		competitionForUserRedirectionTest4 = "Automation Competition 4";
		competitionForUserRedirectionTest5 = "Automation Competition 5";
		
		//Postal code test related
		//phoneForPostalCodeTest = "2345678001";
		phoneForPostalCodeTest = "7700185193";
		phoneForForgetPW="2312345680";
		otpForPostalCodeTest = "123456";
		emailForPostalCodeTest = phoneForPostalCodeTest+"@mailinator.com";

		//High response options dropdown related
		competitionForHighResponseOptionsTest = "Automation Competition 1";
//		competitionForHighResponseOptionsTest = "Test Cometition";
		//Password reset test
		phoneForPasswordResetTest_mailVerify = "2312345680";
		phoneForNewHereRegisterTest = "2312345678";
		phoneForCompetitionTest = "2312345679";
		phoneForOffersTest = "2345678958";
		phoneForPlayNowTest = "2345678961";
		PhoneForPostalcode = "2312345682";
		PhoneForTestUserRegistration = "7893983216";
		//phoneForPasswordResetTest = "1234567985";
		//User registration form test related
		phoneForRegistrationFormTest = "7700185193";
		//phoneForRegistrationFormTest = "kumar";

		

		NewUserRegistrationForPostalCode.put("title", "Mr.");
		NewUserRegistrationForPostalCode.put("firstName", phoneForPostalCodeTest);
		NewUserRegistrationForPostalCode.put("lastName", "lastname");
		NewUserRegistrationForPostalCode.put("email", emailForPostalCodeTest);
		NewUserRegistrationForPostalCode.put("date", "20");
		NewUserRegistrationForPostalCode.put("Month", "JAN");
		NewUserRegistrationForPostalCode.put("year", "1980");
		NewUserRegistrationForPostalCode.put("password", "tester123");
		NewUserRegistrationForPostalCode.put("displayname", phoneForPostalCodeTest);
		NewUserRegistrationForPostalCode.put("postalCode", "xx500x");

		//JISHI related data
		expMsgs.add("No luck by chance here. Play and win great products for yourself");		
		expMsgs.add("We have changed the way competitions run");	
		expMsgs.add("Browse the large catalogue");
		expMsgs.add("Look out for the competition winners in the leader board");
		expMsgs.add("Every week, highest scorer wins additional £50 gift voucher");

		expCompetitionsLink="Competitions";
		expOffersLink="Offers";
		expHowitworksLink="How it works";
		expTxtOnScreen="No luck by chance Chance by you";

		expTitles.add("Four Countries Safari");
		expTitles.add("A Taste of Jordan");
		expTitles.add("Fitbit Versa 2 Smart Watch");
		expTitles.add("Acer Nitro 5 AN515-52 Gaming Notebook");
		expTitles.add("Ethiopian Odyssey");
		expTitles.add("Samsung Galaxy S10 Smartphone");
		expTitles.add("Bosch Indego 400 Connect");
		expTitles.add("Bosch Series 8 ActiveOxygen WAW28750GB Washing Machine");
		expTitles.add("Falkland Islands Holidays");
		expTitles.add("Sony PlayStation 4 Pro");
		expTitles.add("Apple iPhone 11 Pro Max (256GB) - Space Grey");
		expTitles.add("Macbook Pro");
		expTitles.add("Apple Watch Series 5");
		expTitles.add("Essential Japan");
		expTitles.add("Amazon Gift Card");
		expTitles.add("Galaxy Fold 5G");
		expTitles.add("Dyson Cyclone V10 Cordless Vacuum Cleaner");
		expTitles.add("Best of Botswana");
		expTitles.add("Visit Vatican Museum, Sistine Chapel and St. Peter's Basilica");	


		//CRM [Admin]
		location="UK";
	//	CRMClientName="Swathi Test Client 0902";
		CRMClientName="kumar Test Client 0902";
		CRMClientDesc="Swathi Test Description for client";	
		CRMClientprivacyPolicy="https://www.test.org.uk/terms/privacy-policy";
		CRMFullClientDesc = "{\"privacyPolicy\":"+"\""+CRMClientprivacyPolicy+"\""+",\"desc\":"+"\""+CRMClientDesc+"\""+"}";		
	//	CRMCategoryName="Test with Stewart";
		CRMCategoryName="Test Category 008";
		
		CRMCompetitionName="SwathiTestCompetition";
		CRM_clientForCompetition="SSN Internal";
		CRM_categoryForCompetition=CRMCategoryName;
		CRM_endDate="December 31, 2021";
	//	CRM_existingCompetitionName="testing2";
		CRM_existingCompetitionName="Test_Competition";
		CRM_categoryForClient="Utility";
//		CRMOfferName="SwathiTestOffer2901";
		CRMOfferName="Test Offers@test";
		
		CRMOfferDesc="SwathiTestDesc";
		CRMClientForOffer="SSN Internal";
		CRMCategoryForOffer="Shopping";	
		CRMOfferQuestion1="Client Questions (1 segments)";
//		CRMOfferQuestion1="Client Questions";
		CRMOfferQuestion2="Consumer Questions (1 segments)";
		CRMConsumerName="Test EncashUser";
		CRMTestimonial="EncashOffers is exciting. Refer to your friends";
		CRMFeaturedComp="Test2";
	//	CRMFeaturedComp="Test12345";

		featured="FEATURED";
		destComp="Apple Watch - Gold Stainless Steel Case with Sport Loop";
//		CRM_existingOfferName="TestOffer";
		CRM_existingOfferName="Test Category 005";
//		CRM_categoryForOffer="SwathiTestCategory";
		CRM_categoryForOffer="kumar_Test Category";
	//	CRMTenancyOfferName="AutomationTenancyOffer1503";
		CRMTenancyOfferName="kumar_AutomationTenancyOffer1503";
		CRMTenancyOfferDesc="AutomationTenancyDesc";
		CRMTenancyOfferTransferURL="https://www.flipkart.com/";
		CRMTenancyOfferTransferURL_edited="http://staging.encashoffers.com/home";

		//Encash Registration Data
		//last3digits=phone.substring(7);
		NewRegistration.put("title", "Mr.");
		NewRegistration.put("firstName", "FIRSTNAME");
		NewRegistration.put("lastName", "LASTNAME");
		NewRegistration.put("email", phone+"@mailinator.com");
		NewRegistration.put("date", "20");
		NewRegistration.put("Month", "JAN");
		NewRegistration.put("year", "1980");
		NewRegistration.put("password", "tester123");
		NewRegistration.put("displayname", phone);
		displayName=phone;
		NewRegistration.put("postalCode", "KW14YT");
		addquestion();

		//Returning user
		returningUserEmail=phone+"@mailinator.com";
		returningUserPwd="tester123";

		//Competition for the Live Badge
		competitionForLiveBadge="iPhoneX";

		// Mandatory Questions Description related
		phoneForDescriptionTest = "2345678921";
		otpForDescriptionTest = "123456";
		phoneForDescriptionTest_2 = "2345678922";
		otpForDescriptionTest_2 = "123456";
		competitionForDescription = "Test Competition - Kumar"; // Competition for Description
		questionForEditDescription = "What is your current employment status?";
		originalQuestionDescription = "Your right to privacy is very important to us and we take the security of your information seriously.";
		editedQuestionDescription = "Edited_Your right to privacy is very important to us and we take the security of your information seriously_Edited";

		//top offers data
		TopOffersCreatename = "4uKey-iPhone Password Unlocker";
		TopOffersdropname = "Attractiontix Disney Land Paris";

		//featured offers
	//	featuredoffersCreatename = "4uKey-iPhone Backup Unlocker";
		featuredoffersCreatename = "Test Offers @Kumar";
		featuredoffersdropname = "A Quarter Of -Various Giftboxes";

		//Top competition
		TopCompetitionsCreatename = "18ct White Gold Engagement Ring";
		TopCompetitiondropname = "£500 Clarks gift card";
		
		//Competition for Postback pixel tracking
		competitionForPostback = "Automation Competition For Pixel Tracking";
		
		//verifyTenancyEmail
	//	expectedHeading = "Check out our current hot offers right below:";
		expectedHeading = "Once again, thank you for signing up with us.";
	

	//	TenancyOffer1= "Automation Tenancy Offer for Email Content_1";
		TenancyOffer1= "Automation Competition For Pixel Tracking";
				
	//	TenancyOffer2= "Automation Tenancy Offer for Email Content_2";
		
		TenancyOffer2= "Russell Hobbs Mini Fridge";
		
	//	expectedURLForTenancyOffer1 = "https://www.encashoffers.com/offers/all";
		expectedURLForTenancyOffer1 = "null";
	//	expectedURLForTenancyOffer2 = "https://amzn.to/2rz571s";
		expectedURLForTenancyOffer2 = "null";
	//	expectedURL_Click_Here = "https://www.encashoffers.com/offers/all";
		expectedURL_Click_Here = "https://www.mailinator.com/linker?linkid=410b38ed-ff36-4226-b7bf-8fbb7a7036a4";
		

	}

	public HashMap<Integer,QuestionType> addquestion(){

		HashMap<Integer,QuestionType> Questions = new HashMap<Integer,QuestionType>();
		String question1 = "We all shop for various things. Some of us love shopping and for some of us it is a chore. Today you have to help one of the two characters with your shopping skills. Wear the hat of a shopping expert and here you go... Choose your ROBO character:";
		String questiontype1 = "Single";
		List<String> answer1 = new ArrayList<String>();
		answer1.add("Boy");
		int score1 = 2;

		String question2 = "Here is the bucket list full of colours. Which colour of apparel would you suggest to ROBO?";
		String questiontype2 = "Multiple";
		List<String> answer2 = new ArrayList<String>();
		answer2.add("Pink");
		answer2.add("Orange");
		answer2.add("Purple");
		//answer2.add("White");
		int score2 = 6;

		String question3 = "Bravo! Robo, was wondering if you usually shop alone or with someone? Suggest a good shopping partner to Robo.";
		String questiontype3 = "Multiple";
		List<String> answer3 = new ArrayList<String>();
		answer3.add("With Friends");
		answer3.add("Girlfriend/Boyfriend");
		int score3 = 4;

		String question4 = "Do you suggest Robo operates open WiFi while out shopping?";
		String questiontype4 = "Single";
		List<String> answer4 = new ArrayList<String>();
		answer4.add("Yes");
		int score4 = 2;

		String question5 = "Wonderful! Robo loves your selection and finds a true campanion in you. So, Robo wants to know something about you. Robo wants to identify how much you love shopping?";
		String questiontype5 = "Single";
		List<String> answer5 = new ArrayList<String>();
		answer5.add("Seldom");
		int score5 = 2;

		String question6 = "So tell Robo how often you go out shopping?";
		String questiontype6 = "Single";
		List<String> answer6 = new ArrayList<String>();
		answer6.add("Regular");
		int score6 = 2;

		//segment level 2 question 
		String question7 = "Do you regularly play the lottery?";
		String questiontype7 = "Single";
		List<String> answer7 = new ArrayList<String>();
		answer7.add("Yes");
		int score7 = 8;

		String question8 = "Would you like to hear from Your Lotto Service about how you can increase your chances of winning?";
		String questiontype8 = "Single";
		List<String> answer8 = new ArrayList<String>();
		answer8.add("Yes");
		int score8 = 10;

		String question9 = "This question is from Let’s Subscribe, they would like to know if you’d like a free copy of one of the following magazines?";
		String questiontype9 = "Single";
		List<String> answer9 = new ArrayList<String>();
		answer9.add("Puzzled");
		int score9 = 8;

		String question10 = "Can you confirm that you would like to be contacted by Lets Subscribe to arrange your free issue?";
		String questiontype10 = "Single";
		List<String> answer10 = new ArrayList<String>();
		answer10.add("Yes");
		int score10 = 10;

		QuestionType ques1 = new QuestionType();
		ques1.setQuestion(question1);
		ques1.setAnswer(answer1);
		ques1.setQuestionType(questiontype1);
		ques1.setScore(score1);

		QuestionType ques2 = new QuestionType();
		ques2.setQuestion(question2);
		ques2.setAnswer(answer2);
		ques2.setQuestionType(questiontype2);
		ques2.setScore(score2);

		QuestionType ques3 = new QuestionType();
		ques3.setQuestion(question3);
		ques3.setAnswer(answer3);
		ques3.setQuestionType(questiontype3);
		ques3.setScore(score3);

		QuestionType ques4 = new QuestionType();
		ques4.setQuestion(question4);
		ques4.setAnswer(answer4);
		ques4.setQuestionType(questiontype4);
		ques4.setScore(score4);

		QuestionType ques5 = new QuestionType();
		ques5.setQuestion(question5);
		ques5.setAnswer(answer5);
		ques5.setQuestionType(questiontype5);
		ques5.setScore(score5);

		QuestionType ques6 = new QuestionType();
		ques6.setQuestion(question6);
		ques6.setAnswer(answer6);
		ques6.setQuestionType(questiontype6);
		ques6.setScore(score6);

		QuestionType ques7 = new QuestionType();
		ques7.setQuestion(question7);
		ques7.setAnswer(answer7);
		ques7.setQuestionType(questiontype7);
		ques7.setScore(score7);

		QuestionType ques8 = new QuestionType();
		ques8.setQuestion(question8);
		ques8.setAnswer(answer8);
		ques8.setQuestionType(questiontype8);
		ques8.setScore(score8);

		QuestionType ques9 = new QuestionType();
		ques9.setQuestion(question9);
		ques9.setAnswer(answer9);
		ques9.setQuestionType(questiontype9);
		ques9.setScore(score9);

		QuestionType ques10 = new QuestionType();
		ques10.setQuestion(question10);
		ques10.setAnswer(answer10);
		ques10.setQuestionType(questiontype10);
		ques10.setScore(score10);

		Questions.put(1, ques1);
		Questions.put(2, ques2);
		Questions.put(3, ques3);
		Questions.put(4, ques4);
		Questions.put(5, ques5);
		Questions.put(6, ques6);
		Questions.put(7, ques7);
		Questions.put(8, ques8);
		Questions.put(9, ques9);
		Questions.put(10, ques10);

		return Questions;
	}

	public HashMap<String,String> EditCompetitiondata() {

		HashMap<String,String>competition = new HashMap<String,String>();
		competition.put("Name", "Competition_Name_Edit");
		competition.put("Description", "Description has been Edit");
		competition.put("client","testclient");
		competition.put("location","UK");
		competition.put("categories", "Test Offers @Kumar");
		competition.put("Enddate", "31");
		competition.put("EndMonth", "Dec");
		competition.put("EndYear", "2022");
		competition.put("isActive", "yes");

		return competition;

	}

	public HashMap<String,String> OriginalCompetitiondata() {

		HashMap<String,String>competition = new HashMap<String,String>();
		competition.put("Name", "Test_Competition");
		competition.put("Description", "Description has orignial");
		competition.put("client","SSN Internal");
		competition.put("location","UK");
		competition.put("categories", "Shopping");
		competition.put("Enddate", "27");
		competition.put("EndMonth", "Dec");
		competition.put("EndYear", "2020");
		competition.put("isActive", "yes");

		return competition;

	}

	/**
	 * Competition survey question	
	 * @return
	 */
	public HashMap<Integer,QuestionType> MandatoryQuestion(){

		HashMap<Integer,QuestionType> Questions = new HashMap<Integer,QuestionType>();
		String question1 = "Would you be interested in speaking with someone to see you can get maximum benefits out of your investments Automation Testing?";
		String questiontype1 = "Single";
		List<String> answer1 = new ArrayList<String>();
		answer1.add("Yes");
		int score1 = 0;

		String question2 = "Would you be interested in speaking with a consultant from one of our energy partners, to discuss if they could save you money Automation Testing?";
		String questiontype2 = "Single";
		List<String> answer2 = new ArrayList<String>();
		answer2.add("Yes");
		int score2 = 0;

		String question3 = "Generally, when do you watch TV?";
		String questiontype3 = "Single";
		List<String> answer3 = new ArrayList<String>();
		answer3.add("I don't watch TV");
		int score3 = 0;

		String question4 = "Where were you when you looked at/listened to the news yesterday? Choose as many as you want";
		String questiontype4 = "Multiple";
		List<String> answer4 = new ArrayList<String>();
		answer4.add("At work");
		answer4.add("At a place of study");
		int score4 = 0;

		String question5 = "Would you be interested in speaking with someone to see you can get maximum benefits out of your investments?";
		String questiontype5 = "Single";
		List<String> answer5 = new ArrayList<String>();
		answer5.add("Yes");
		int score5 = 0;

		//segment level 2 question 
		String question6 = "Robo would love to stay in your selected option. Also guide Robo, how should Robo book the stay?";
		String questiontype6 = "Single";
		List<String> answer6 = new ArrayList<String>();
		answer6.add("Book stay in advance - online");
		int score6 = 0;

		String question7 = "You choose Insurance. Do you think insurance is important for everyone?";
		String questiontype7 = "Single";
		List<String> answer7 = new ArrayList<String>();
		answer7.add("Yes");
		int score7 = 0;

		String question8 = "And what is the reason for getting a mortgage loan?";
		String questiontype8 = "Single";
		List<String> answer8 = new ArrayList<String>();
		answer8.add("To buy a property");
		int score8 = 0;

		String question9 = "So, has the monetary value of the property you got mortgage for appreciated?";
		String questiontype9 = "Single";
		List<String> answer9 = new ArrayList<String>();
		answer9.add("Yes");
		int score9 = 0;

		String question10 = "So, according to you how important is will?";
		String questiontype10 = "Single";
		List<String> answer10 = new ArrayList<String>();
		answer10.add("Extremely important");
		int score10 = 0;

		String question11 = "Then, how should Robo's father search/prepare for it?";
		String questiontype11 = "Multiple";
		List<String> answer11 = new ArrayList<String>();
		answer11.add("Personal Referrals");
		answer11.add("Lawyer Referral Services");
		int score11 = 0;

		String question12 = "What is your home ownership status?";
		String questiontype12 = "Single";
		List<String> answer12 = new ArrayList<String>();
		answer12.add("Private tenant");
		int score12 = 0;

		String question13 = "What is your preferred way of doing shopping";
		String questiontype13 = "Single";
		List<String> answer13 = new ArrayList<String>();
		answer13.add("Both");
		int score13 = 0;


		QuestionType ques1 = new QuestionType();
		ques1.setQuestion(question1);
		ques1.setAnswer(answer1);
		ques1.setQuestionType(questiontype1);
		ques1.setScore(score1);

		QuestionType ques2 = new QuestionType();
		ques2.setQuestion(question2);
		ques2.setAnswer(answer2);
		ques2.setQuestionType(questiontype2);
		ques2.setScore(score2);

		QuestionType ques3 = new QuestionType();
		ques3.setQuestion(question3);
		ques3.setAnswer(answer3);
		ques3.setQuestionType(questiontype3);
		ques3.setScore(score3);

		QuestionType ques4 = new QuestionType();
		ques4.setQuestion(question4);
		ques4.setAnswer(answer4);
		ques4.setQuestionType(questiontype4);
		ques4.setScore(score4);

		QuestionType ques5 = new QuestionType();
		ques5.setQuestion(question5);
		ques5.setAnswer(answer5);
		ques5.setQuestionType(questiontype5);
		ques5.setScore(score5);

		QuestionType ques6 = new QuestionType();
		ques6.setQuestion(question6);
		ques6.setAnswer(answer6);
		ques6.setQuestionType(questiontype6);
		ques6.setScore(score6);

		QuestionType ques7 = new QuestionType();
		ques7.setQuestion(question7);
		ques7.setAnswer(answer7);
		ques7.setQuestionType(questiontype7);
		ques7.setScore(score7);

		QuestionType ques8 = new QuestionType();
		ques8.setQuestion(question8);
		ques8.setAnswer(answer8);
		ques8.setQuestionType(questiontype8);
		ques8.setScore(score8);

		QuestionType ques9 = new QuestionType();
		ques9.setQuestion(question9);
		ques9.setAnswer(answer9);
		ques9.setQuestionType(questiontype9);
		ques9.setScore(score9);

		QuestionType ques10 = new QuestionType();
		ques10.setQuestion(question10);
		ques10.setAnswer(answer10);
		ques10.setQuestionType(questiontype10);
		ques10.setScore(score10);

		QuestionType ques11 = new QuestionType();
		ques11.setQuestion(question11);
		ques11.setAnswer(answer11);
		ques11.setQuestionType(questiontype11);
		ques11.setScore(score11);

		QuestionType ques12 = new QuestionType();
		ques12.setQuestion(question12);
		ques12.setAnswer(answer12);
		ques12.setQuestionType(questiontype12);
		ques12.setScore(score12);

		QuestionType ques13 = new QuestionType();
		ques13.setQuestion(question13);
		ques13.setAnswer(answer13);
		ques13.setQuestionType(questiontype13);
		ques13.setScore(score13);

		/*
		QuestionType ques11 = new QuestionType();
		ques11.setQuestion(question11);
		ques11.setAnswer(answer11);
		ques11.setQuestionType(questiontype11);
		ques11.setScore(score11);
		 */
		Questions.put(1, ques1);
		Questions.put(2, ques2);
		Questions.put(3, ques3);
		Questions.put(4, ques4);
		Questions.put(5, ques5);
		Questions.put(6, ques6);
		Questions.put(7, ques7);
		Questions.put(8, ques8);
		Questions.put(9, ques9);
		Questions.put(10, ques10);
		Questions.put(11, ques11);
		Questions.put(12, ques12);
		Questions.put(13, ques13);

		return Questions;
	}

	public HashMap<Integer,QuestionType> surveyquestion(){

		HashMap<Integer,QuestionType> Questions = new HashMap<Integer,QuestionType>();
		String question1 = "We all shop for various things. Some of us love shopping and for some of us it is a chore. Today you have to help one of the two characters with your shopping skills. Wear the hat of a shopping expert and here you go... Choose your ROBO character Automation Testing:)";
		String questiontype1 = "Single";
		List<String> answer1 = new ArrayList<String>();
		answer1.add("Boy");
		int score1 = 1;

		String question2 = "So, according to you how important is will Automation testing?";
		String questiontype2 = "Single";
		List<String> answer2 = new ArrayList<String>();
		answer2.add("Extremely important");
		int score2 = 1;

		QuestionType ques1 = new QuestionType();
		ques1.setQuestion(question1);
		ques1.setAnswer(answer1);
		ques1.setQuestionType(questiontype1);
		ques1.setScore(score1);

		QuestionType ques2 = new QuestionType();
		ques2.setQuestion(question2);
		ques2.setAnswer(answer2);
		ques2.setQuestionType(questiontype2);
		ques2.setScore(score2);

		Questions.put(1, ques1);
		Questions.put(2, ques2);

		return Questions;

	}
	
	public HashMap<Integer,QuestionType> mandatoryqueston(){

		HashMap<Integer,QuestionType> Questions = new HashMap<Integer,QuestionType>();
		String question1 = "Thinking specifically about when you look for news on a MOBILE, which of the following statements most applies to you?";
		String questiontype1 = "";
		List<String> answer1 = new ArrayList<String>();
		answer1.add("I mainly use news apps I downloaded from an app store");
		int score1 = 1;

		String question2 = "How often do you eat fast food?";
		String questiontype2 = "";
		List<String> answer2 = new ArrayList<String>();
		answer2.add("Once or twice a week");
		int score2 = 1;
		
		String question3 = "State which characteristics best describes your diet. Choose as many as you want";
		String questiontype3 = "";
		List<String> answer3 = new ArrayList<String>();
		answer3.add("High in fruit and salad");
		answer3.add("High in fast food");
		answer3.add("High in seafood and poultry meat");
		answer3.add("High in vegetables and pulses");
		answer3.add("All of it");
		int score3 = 5;
		
		String question4 = "Below is a list of common foods. Please tick the three choices that you usually consume";
		String questiontype4 = "";
		List<String> answer4 = new ArrayList<String>();
		answer4.add("Soup");
		answer4.add("Fruit juice");
		answer4.add("Frozen Food");
		answer4.add("Nuts");
		answer4.add("I rarely consume them");
		int score4 = 5;
		
		String question5 = "How often do you consume ready to eat food?";
		String questiontype5 = "";
		List<String> answer5 = new ArrayList<String>();
		answer5.add("Special occasions only");
		int score5 = 1;

		String question6 = "How many people do you buy groceries for?";
		String questiontype6 = "";
		List<String> answer6 = new ArrayList<String>();
		answer6.add("1-2");
		int score6 = 1;
		
		String question7 = "What was the reason for buying your car/bike?";
		String questiontype7 = "";
		List<String> answer7 = new ArrayList<String>();
		answer7.add("This is my first vehicle");
		answer7.add("Previous one broke down");
		answer7.add("I don't have a car");
		int score7 = 1;
		
		String question8 = "How far is your office from your residence";
		String questiontype8 = "";
		List<String> answer8 = new ArrayList<String>();
		answer8.add("I don't work");
		int score8 = 1;
		
		QuestionType ques1 = new QuestionType();
		ques1.setQuestion(question1);
		ques1.setAnswer(answer1);
		ques1.setQuestionType(questiontype1);
		ques1.setScore(score1);

		QuestionType ques2 = new QuestionType();
		ques2.setQuestion(question2);
		ques2.setAnswer(answer2);
		ques2.setQuestionType(questiontype2);
		ques2.setScore(score2);
		
		QuestionType ques3 = new QuestionType();
		ques3.setQuestion(question3);
		ques3.setAnswer(answer3);
		ques3.setQuestionType(questiontype3);
		ques3.setScore(score3);

		QuestionType ques4 = new QuestionType();
		ques4.setQuestion(question4);
		ques4.setAnswer(answer4);
		ques4.setQuestionType(questiontype4);
		ques4.setScore(score4);
		
		QuestionType ques5 = new QuestionType();
		ques5.setQuestion(question5);
		ques5.setAnswer(answer5);
		ques5.setQuestionType(questiontype5);
		ques5.setScore(score5);

		QuestionType ques6 = new QuestionType();
		ques6.setQuestion(question6);
		ques6.setAnswer(answer6);
		ques6.setQuestionType(questiontype6);
		ques6.setScore(score6);
		
		QuestionType ques7 = new QuestionType();
		ques7.setQuestion(question7);
		ques7.setAnswer(answer7);
		ques7.setQuestionType(questiontype7);
		ques7.setScore(score7);

		QuestionType ques8 = new QuestionType();
		ques8.setQuestion(question8);
		ques8.setAnswer(answer8);
		ques8.setQuestionType(questiontype8);
		ques8.setScore(score8);

		Questions.put(1, ques1);
		Questions.put(2, ques2);
		Questions.put(3, ques3);
		Questions.put(4, ques4);
		Questions.put(5, ques5);
		Questions.put(6, ques6);
		Questions.put(7, ques7);
		Questions.put(8, ques8);

		return Questions;

	}
	
	

}
