package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Route {
    private Long id;
    private String name;
    private String from;
    private String to;

    public Route(Long id, String name, String from, String to) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
