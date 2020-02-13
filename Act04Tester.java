public class Act04Tester {
	public static void main(String[] args) {
		System.out.println("*** Start of Activity 4, Test 1 ***");	
		// Prints out the sentiment value of the original review
		System.out.println(Review.totalSentiment("DoofIncReview.txt"));
        System.out.println(Review.totalSentiment("DoofIncReview.txt"));


        

		// Prints out the original review (no changes)
		System.out.println(Review.fakeReview_v2("DoofIncReview.txt"));
        System.out.println(Review.totalSentiment("fakeRev2.txt"));
    	System.out.println();
    	// Prints out the sentiment value of the new review
    	// If your totalSentiment does not remove the starting punctuation, copy your new
    	// fake review into a .TXT file and check its sentiment value.
    	System.out.println(Review.totalSentiment("DoofIncANNOTATED.txt"));
    	// Prints out the fake review
    	System.out.println(Review.fakeReview_v2("DoofIncANNOTATED.txt"));

    	System.out.println("*** Start of Activity 4, Test 2 ***");	
		// Prints out the original review (no changes)
		System.out.println(Review.fakeReview_v2("AgentPReview.txt"));
    	System.out.println();
    	// Prints out the fake review
        System.out.println(Review.totalSentiment("AgentPReview.txt"));
    	System.out.println(Review.fakeReview_v2("AgentPANNOTATED.txt"));
        System.out.println(Review.totalSentiment("newRev.txt"));

	}

}