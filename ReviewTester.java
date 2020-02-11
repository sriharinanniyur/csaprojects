public class ReviewTester {
    // Activity 2: Sentiment Value & Star Ratings
    // Make sure the review .txt files & this tester file are in the same folder as your Review.java file.
  public static void main(String[] args)
  {
    System.out.println(Review.totalSentiment("ChezPerryReview.txt"));
    System.out.println("Testing Fake Review v1");
    System.out.println(Review.fakeReview("ChezPerryReviewAnnotated.txt"));
    System.out.println("Testing Fake Review v2");
    System.out.println(Review.fakeReview_v2("ChezPerryReviewAnnotated.txt"));
  }
}
