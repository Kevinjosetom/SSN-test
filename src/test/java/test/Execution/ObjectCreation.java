 package test.Execution;

import org.testng.annotations.BeforeClass;
import ActionEngine.ReadExcelData;
import pageObjects.Bank_Details_Page_Validation;
import pageObjects.CompetitionsWeb;
import pageObjects.ConsumerRedirectionToOffersPage_Test1;
import pageObjects.CreateCategory_AssignOffer_DeleteCategory;
import pageObjects.CreateClient_Verify_NewUser_DisableClient;
import pageObjects.CreateClient_Verify_ReturningUser_disableClient;
import pageObjects.CreateEditDelete_Testimonials;
import pageObjects.CreateEditFeaturedCompetitions_T12;
import pageObjects.CreateOffer_Verify_DisableOffer_NewUser;
import pageObjects.CreateOffer_Verify_DisableOffer_ReturningUser;
import pageObjects.Create_Edit_Disable_TenancyOffer;
import pageObjects.Crm_CompetationEdit;
import pageObjects.Customer_InformationPage_validations;
import pageObjects.Encah_signup_validations;
import pageObjects.Encash_Registration_Validations;
import pageObjects.Encasht1_1_Email_and_OTP_Validations;
import pageObjects.Encasht_1_2verify_login_new_resistred;
import pageObjects.Featured_offers_T11;
import pageObjects.Postalcode_Test_New_User;
import pageObjects.Quote_summary_Validations;
import pageObjects.Test_Description_For_Questions;
import pageObjects.Test_Encashui_Password_Reset_Functionality;
import pageObjects.Test_High_Response_Options_Dropdown;
import pageObjects.Test_Live_Badge;
import pageObjects.Test_User_Registration_Dialog;
import pageObjects.Top_Competitions_T14;
import pageObjects.VerifyPostback;
import pageObjects.VerifyTenancyEmail;
import pageObjects.YBC_Confirm_Bank_Details_Page_Validations;
import pageObjects.YBC_Thank_you_And_SocialMediaLink_Validations;
import pageObjects.Ybc_home_page_objects;
import pageObjects.Your_Selected_applience;
import pageObjects.createClient_verifyInPrivacyPolicy_DisableClient;
import pageObjects.crmUI_AddCategoryToExistingCompetition;
import pageObjects.encash_offers_signup_page_objects;
import pageObjects.forgotPasswordTest;
import pageObjects.sighup_page_validations;
import pageObjects.topOffers_T13;




   public class ObjectCreation extends ReadExcelData {
		protected sighup_page_validations sign_up;
		protected encash_offers_signup_page_objects En_sign;
		protected crmUI_AddCategoryToExistingCompetition crmui_addcategory; 
		protected CompetitionsWeb CompetitionWeb;
		protected Encash_Registration_Validations registration;
		protected createClient_verifyInPrivacyPolicy_DisableClient create_disable_client;
		protected CreateClient_Verify_NewUser_DisableClient NewUser_DisableClient;
		protected CreateClient_Verify_ReturningUser_disableClient ReturningUser_disableClient;
		protected CreateOffer_Verify_DisableOffer_NewUser DisableOffer_NewUser;
		protected CreateOffer_Verify_DisableOffer_ReturningUser DisableOffer_ReturningUser;
		protected CreateEditDelete_Testimonials  Testimonials;
		protected Encasht1_1_Email_and_OTP_Validations Encasht1_1;
		protected Encasht_1_2verify_login_new_resistred Encash_t1_2;
		protected Postalcode_Test_New_User Postalcode;
		protected Test_High_Response_Options_Dropdown test_high_response;
		protected Test_Live_Badge Live_Badge;
		protected Test_User_Registration_Dialog Test_user;
		protected Featured_offers_T11 featured_offers;
		protected CreateEditFeaturedCompetitions_T12 createEditFeatured;
		protected Test_Encashui_Password_Reset_Functionality Password_Reset;
	    protected Test_Description_For_Questions Test_Description;
	    protected forgotPasswordTest forget_PW;
	    protected topOffers_T13 top;
	    protected Crm_CompetationEdit crm;
	    protected CreateCategory_AssignOffer_DeleteCategory CreateCategory;
	    protected Top_Competitions_T14 topCompetitions;
	    protected Create_Edit_Disable_TenancyOffer Tenancy_offer;
	    protected ConsumerRedirectionToOffersPage_Test1  ConsumerRedirection;
	    protected VerifyPostback postback;
	    protected VerifyTenancyEmail email;
	    protected Encah_signup_validations sign_up1;
	    protected Ybc_home_page_objects Ybc_homepage;
	    protected Your_Selected_applience ysp;
	    protected Quote_summary_Validations Quote;
	    protected Customer_InformationPage_validations CI;
	    protected Bank_Details_Page_Validation bank;
	    protected YBC_Confirm_Bank_Details_Page_Validations Confirm_Bank;
	    protected YBC_Thank_you_And_SocialMediaLink_Validations Thank_you;

	@BeforeClass
	public void beforeClass() {
		
		sign_up = new sighup_page_validations(driver);
		En_sign = new encash_offers_signup_page_objects(driver);
		crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver); 
		CompetitionWeb = new CompetitionsWeb(driver);
		registration = new Encash_Registration_Validations(driver);
		create_disable_client = new createClient_verifyInPrivacyPolicy_DisableClient(driver);
		NewUser_DisableClient= new CreateClient_Verify_NewUser_DisableClient(driver);
		ReturningUser_disableClient = new CreateClient_Verify_ReturningUser_disableClient(driver);
	    DisableOffer_NewUser = new CreateOffer_Verify_DisableOffer_NewUser(driver);
	    DisableOffer_ReturningUser = new CreateOffer_Verify_DisableOffer_ReturningUser(driver);
	    Testimonials = new CreateEditDelete_Testimonials(driver);
	    Encasht1_1 = new Encasht1_1_Email_and_OTP_Validations(driver);
	    Encash_t1_2 = new Encasht_1_2verify_login_new_resistred(driver);
	    Postalcode = new Postalcode_Test_New_User(driver);
	    test_high_response = new Test_High_Response_Options_Dropdown(driver);
	    Live_Badge = new Test_Live_Badge(driver);
	    Test_user= new Test_User_Registration_Dialog(driver);
	    featured_offers = new Featured_offers_T11(driver);
	    createEditFeatured = new CreateEditFeaturedCompetitions_T12(driver);
	    Password_Reset = new Test_Encashui_Password_Reset_Functionality(driver);
	    Test_Description = new Test_Description_For_Questions(driver);
	    forget_PW = new forgotPasswordTest(driver);
	    top =new topOffers_T13(driver);
	    crm = new Crm_CompetationEdit(driver);
	    CreateCategory = new CreateCategory_AssignOffer_DeleteCategory(driver);
	    topCompetitions= new Top_Competitions_T14(driver);
	    Tenancy_offer =  new Create_Edit_Disable_TenancyOffer(driver);
	    ConsumerRedirection = new ConsumerRedirectionToOffersPage_Test1(driver);
	    postback = new VerifyPostback(driver);
	    email = new VerifyTenancyEmail(driver);
	    sign_up1 = new Encah_signup_validations(driver);
	    Ybc_homepage= new Ybc_home_page_objects(driver);
	    ysp = new Your_Selected_applience(driver);
	    Quote= new Quote_summary_Validations(driver);
	    CI= new Customer_InformationPage_validations(driver);
	    bank = new Bank_Details_Page_Validation(driver);
	    Confirm_Bank = new YBC_Confirm_Bank_Details_Page_Validations(driver);
	    Thank_you = new YBC_Thank_you_And_SocialMediaLink_Validations(driver);

	    }  
	    
	 
   }