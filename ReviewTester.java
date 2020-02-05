
public class ReviewTester {
    public static void main(String[] args) {
        System.out.println(Review.sentimentVal("bad"));
        System.out.println(Review.sentimentVal("frenzy"));
        System.out.println(Review.sentimentVal("hilarious"));
        System.out.println(Review.sentimentVal("low"));
        System.out.println(Review.sentimentVal("college"));
        
        System.out.println(Review.totalSentimentVal("~/Desktop/proj04CSA/SimpleReview.txt"));
    }
}
