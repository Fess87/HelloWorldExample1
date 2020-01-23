package com.example.notessavelyev;

import java.util.Objects;

public class Note {
    private String head;
    private String body;
    private boolean hasDeadLine;
    private String deadlineDate;

    public Note(String head, String body, boolean hasDeadLine, String deadlineDate) {
        this.head = head;
        this.body = body;
        this.hasDeadLine = hasDeadLine;
        this.deadlineDate = deadlineDate;
    }

    public Note(String head, String body, boolean hasDeadLine) {
        this.head = head;
        this.body = body;
        this.hasDeadLine = hasDeadLine;
    }

    public Note(String head, String body, String deadlineDate) {
        this.head = head;
        this.body = body;
        this.deadlineDate = deadlineDate;
    }

    public Note(String head, String body) {
        this.head = head;
        this.body = body;
    }


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public boolean isHasDeadLine() {
        return hasDeadLine;
    }

    public void setHasDeadLine(boolean hasDeadLine) {
        this.hasDeadLine = hasDeadLine;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}
