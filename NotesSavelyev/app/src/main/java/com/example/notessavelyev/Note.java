package com.example.notessavelyev;

public class Note {
    private String head;
    private String body;
    private String deadlineDate;


    public Note(String body, String head, String deadlineDate) {
        this.body = body;
        this.head = head;
        this.deadlineDate = deadlineDate;
    }

    public Note(String body, String head) {
        this.body = body;
        this.head = head;
    }

    public Note(String body) {
        this.body = body;
    }

    public String getHead() {
        return head;
    }

    public String getBody() {
        return body;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }
}
