package com.example.todolist.service;

import com.example.todolist.model.ToDoItem;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ToDoService {

  // Thread-safe in-memory storage for ToDoItems
  private final ConcurrentHashMap<Long, ToDoItem> items = new ConcurrentHashMap<>();
  private final AtomicLong idCounter = new AtomicLong(0);

  // Create a defensive clone to prevent external mutation of internal state
  private ToDoItem cloneItem(ToDoItem item) {
    if (item == null) {
      return null;
    }
    ToDoItem clone = new ToDoItem(item.getDescription(), item.getDueDate(), item.getPriority(), item.getCategory());
    clone.setId(item.getId());
    clone.setCompleted(item.isCompleted());
    return clone;
  }

  // Create a new ToDoItem with an auto-generated unique ID
  public ToDoItem createToDoItem(ToDoItem item) {
    if (item == null) {
      return null;
    }
    // Basic validation
    if (item.getDescription() == null || item.getDescription().trim().isEmpty()) {
      return null;
    }
    if (item.getDueDate() == null) {
      return null;
    }
    if (item.getPriority() == null) {
      return null;
    }
    long id = idCounter.incrementAndGet();
    item.setId(id);
    items.put(id, item);
    return cloneItem(item);
  }

  // Retrieve all ToDoItems as defensive copies
  public List<ToDoItem> getAllToDoItems() {
    return items.values().stream().map(this::cloneItem).collect(Collectors.toList());
  }

  // Retrieve a ToDoItem by ID; returns null if not found
  public ToDoItem getToDoItemById(Long id) {
    if (id == null) {
      return null;
    }
    ToDoItem item = items.get(id);
    return cloneItem(item);
  }

  // Update an existing ToDoItem. Returns a clone of the updated item or null if not found
  public ToDoItem updateToDoItem(ToDoItem updatedItem) {
    if (updatedItem == null || updatedItem.getId() == null) {
      return null;
    }
    Long id = updatedItem.getId();
    ToDoItem existing = items.get(id);
    if (existing == null) {
      return null;
    }
    // Apply updates (only non-null fields are updated). If a field is explicitly set null, it is ignored to preserve existing data.
    if (updatedItem.getDescription() != null) {
      existing.setDescription(updatedItem.getDescription());
    }
    if (updatedItem.getDueDate() != null) {
      existing.setDueDate(updatedItem.getDueDate());
    }
    if (updatedItem.getPriority() != null) {
      existing.setPriority(updatedItem.getPriority());
    }
    if (updatedItem.getCategory() != null) {
      existing.setCategory(updatedItem.getCategory());
    }
    existing.setCompleted(updatedItem.isCompleted());
    return cloneItem(existing);
  }

  // Delete a ToDoItem by ID
  public boolean deleteToDoItem(Long id) {
    if (id == null) {
      return false;
    }
    return items.remove(id) != null;
  }
}
