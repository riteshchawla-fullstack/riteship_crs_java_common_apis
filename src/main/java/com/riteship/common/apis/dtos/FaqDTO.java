package com.riteship.common.apis.dtos;

public class FaqDTO {
    private Integer faqId;
    private String faqQuestion;
    private String faqAnswer;

    public Integer getFaqId() {
        return this.faqId;
    }

    public void setFaqId(Integer faqId) {
        this.faqId = faqId;
    }

    public String getFaqQuestion() {
        return this.faqQuestion;
    }

    public void setFaqQuestion(String faqQuestion) {
        this.faqQuestion = faqQuestion;
    }

    public String getFaqAnswer() {
        return this.faqAnswer;
    }

    public void setFaqAnswer(String faqAnswer) {
        this.faqAnswer = faqAnswer;
    }
}
