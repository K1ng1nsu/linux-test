package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,name = "lang_code")
    private String langCode;

    @Column(nullable = false)
    private String message;

    public Greeting(Long id, String langCode, String message) {
        this.id = id;
        this.langCode = langCode;
        this.message = message;
    }

    public Greeting() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
