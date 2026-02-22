package com.example.todo.model;

/**
 * TodoItem represents a task item with a title and an optional description.
 */
public class TodoItem {

    private String title;
    private String description;

    // No-arg constructor for frameworks and deserialization
    public TodoItem() {
    }

    // Convenience constructor with title only
    public TodoItem(String title) {
        this.title = title;
    }

    // Full constructor
    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (title != null ? !title.equals(todoItem.title) : todoItem.title != null) return false;
        return description != null ? description.equals(todoItem.description) : todoItem.description == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
