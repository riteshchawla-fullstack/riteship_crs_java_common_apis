package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "faq")
public class Faq {
    @Id
    @Column(name = "faq_id")
    private Integer faqId;

    @Column(name = "faq_question")
    private String faqQuestion;

    @Column(name = "faq_answer")
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
