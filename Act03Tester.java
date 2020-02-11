public class Act03Tester {
	public static void main(String[] args) {
		System.out.println("*** Start of Activity 3 Test ***");	
		// Prints out the original review (no changes)
		System.out.println(Review.fakeReview("PFThemeParkReview.txt"));
    	System.out.println();
    	// Prints out the fake review
    	System.out.println(Review.fakeReview("PFThemeParkANNOTATED.txt"));
	}

}
