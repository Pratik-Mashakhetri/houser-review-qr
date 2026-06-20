package com.controller;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

	

    private final List<String> reviews = List.of(
            "Great furniture quality and smooth rental experience.",
            "Very good service and the furniture was clean and comfortable.",
            "Affordable rental plans and quick delivery. Highly recommended.",
            "Nice collection of furniture and helpful support team.",
            "Good experience overall. The product quality was better than expected.",
            "The delivery was quick and the furniture looked clean and well maintained.",
            "Very useful service for renting furniture at a reasonable price.",
            "Happy with the product quality and overall service experience.",
            "The furniture was comfortable and the rental process was simple.",
            "Good service, polite team, and nice furniture options.",
            "Excellent quality furniture and hassle-free rental process.",
            "The staff was supportive and delivery was on time.",
            "Furniture arrived in excellent condition and looked brand new.",
            "Easy booking process and professional service.",
            "Very satisfied with the quality and affordability.",
            "The rental plans are flexible and budget friendly.",
            "Prompt delivery and installation by the team.",
            "Furniture quality exceeded my expectations.",
            "Smooth experience from ordering to delivery.",
            "Highly satisfied with the service and support.",
            "Clean and well-maintained furniture provided.",
            "Great option for temporary furniture needs.",
            "The sofa was comfortable and looked premium.",
            "Quick response from customer support whenever needed.",
            "Good value for money and reliable service.",
            "The furniture matched exactly what was shown online.",
            "Professional team and timely delivery.",
            "Renting furniture has never been this easy.",
            "The entire process was simple and convenient.",
            "Very impressed with the furniture quality.",
            "Affordable pricing and excellent customer service.",
            "The products were delivered and installed professionally.",
            "Perfect solution for furnished living without buying.",
            "The team handled everything smoothly and efficiently.",
            "Furniture was stylish, clean, and comfortable.",
            "Amazing experience and definitely worth recommending.",
            "The delivery executives were polite and helpful.",
            "Excellent collection of furniture to choose from.",
            "Everything was delivered exactly as promised.",
            "Great service with transparent pricing.",
            "The quality of furniture was outstanding.",
            "Very convenient rental plans and easy process.",
            "Good communication and prompt assistance.",
            "The furniture made my home feel complete.",
            "Highly recommended for anyone looking to rent furniture.",
            "Fast delivery and excellent product condition.",
            "Reliable service and quality furniture options.",
            "The entire experience was stress-free and pleasant.",
            "Furniture looked modern and was very comfortable.",
            "One of the best furniture rental experiences I've had."
    );

    @GetMapping("/api/review")
    public String getRandomReview() {
        Random random = new Random();
        return reviews.get(random.nextInt(reviews.size()));
    }
}
