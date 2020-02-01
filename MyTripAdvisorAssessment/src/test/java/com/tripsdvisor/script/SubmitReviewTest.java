package com.tripsdvisor.script;
/**
 * 
 * @author HenTryRAj
 *
 */

import java.io.IOException;

import org.testng.annotations.Test;

import com.autodesk.generic.BaseClass;
import com.tripadvisor.pages.ClubMahindraPage;
import com.tripadvisor.pages.HomePage;
import com.tripadvisor.pages.ReviewPage;
import com.tripadvisor.pages.SearchResultPage;

public class SubmitReviewTest extends BaseClass {
	
	@Test
	public void submitReviewTripAdvisorTest() throws IOException, InterruptedException {
		String place = fileLib.getDataFromProperties("data");
		String reviewTit = fileLib.getDataFromProperties("reviewTit");
		String 	description = fileLib.getDataFromProperties("description");
		
		HomePage hp = new HomePage(driver);
		SearchResultPage searchPage = hp.navigateToSearchResultPage(place);
		
		ClubMahindraPage clubMah = searchPage.navigateToClubMahindraPage();
		
		ReviewPage review = clubMah.naviagteToReviewPage();
		 review.getReview(reviewTit, description);
	}
}
