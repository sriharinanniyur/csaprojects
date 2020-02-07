import java.io.*;
public class ReviewTester {
    public static void main(String[] args) {
        System.out.println("INDIVIDUAL WORD SENTIMENT VALS:");
        System.out.println(Review.sentimentVal("bad"));
        System.out.println(Review.sentimentVal("frenzy"));
        System.out.println(Review.sentimentVal("hilarious"));
        System.out.println(Review.sentimentVal("low"));
        System.out.println(Review.sentimentVal("college"));
        
        System.out.println("\nTOTAL SENTIMENT VALS AND STAR RATINGS:");
        System.out.println(Review.totalSentimentVal("reviews/review1.txt"));
		System.out.println(Review.starRating("reviews/review1.txt"));
        System.out.println(Review.totalSentimentVal("reviews/review2.txt"));
        System.out.println(Review.starRating("reviews/review2.txt"));
        System.out.println(Review.totalSentimentVal("reviews/review3.txt"));
        System.out.println(Review.starRating("reviews/review3.txt"));
    }
}
