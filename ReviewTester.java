public class ReviewTester {
    // Activity 2: Sentiment Value & Star Ratings
    // Make sure the review .txt files & this tester file are in the same folder as your Review.java file.
  public static void main(String[] args)
  {
    System.out.println(Review.totalSentiment("ChezPerryReview.txt")); 
    
    System.out.println(Review.starRating("ChezPerryReview.txt")); 
    
    System.out.println(Review.totalSentiment("InatorInnReview.txt")); 
    
    System.out.println(Review.starRating("InatorInnReview.txt")); 

    System.out.println("Testing Fake Review"); 

    System.out.println(Review.fakeReview("ChezPerryReviewAnnotated.txt")); 
  }
}