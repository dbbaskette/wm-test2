package com.example.todolist.service;

import com.example.todolist.model.ToDoItem;

import java.util.ArrayList;
import java.util.List;

public class ToDoService {

  // In-memory storage for ToDoItem objects
  private final List<ToDoItem> items = new ArrayList<>();
  private long currentId = 0L;

  // Generate a sequential unique ID for new items
  private synchronized long nextId() {
    return ++currentId;
  }

  /**
   * Create a new ToDoItem, assigning it a unique ID.
   * The provided item should have description, dueDate, priority, and category set.
   * The method will set the generated ID on the item and store it in memory.
   *
   * @param item ToDoItem without an ID
   * @return The same item instance with ID populated, or null if input is null
   */
  public ToDoItem createToDoItem(ToDoItem item) {
    if (item == null) {
      return null;
    }
    long id = nextId();
    item.setId(id);
    items.add(item);
    return item;
  }

  /**
   * Retrieve all ToDoItems.
   * Returns a copy to prevent external modification of internal state.
   *
   * @return List of all ToDoItems
   */
  public List<ToDoItem> getAllToDoItems() {
    return new ArrayList<>(items);
  }

  /**
   * Retrieve a ToDoItem by its ID.
   * Returns null if no item with the given ID exists.
   *
   * @param id ID of the ToDoItem
   * @return ToDoItem or null
   */
  public ToDoItem getToDoItemById(Long id) {
    if (id == null) {
      return null;
    }
    for (ToDoItem item : items) {
      if (id.equals(item.getId())) {
        return item;
      }
    }
    return null;
  }

  /**
   * Update an existing ToDoItem. The item must have a valid ID.
   * If found, updates the fields of the existing item and returns it.
   * Returns null if no item with the given ID exists.
   *
   * @param updatedItem ToDoItem with updated fields and a valid ID
   * @return Updated ToDoItem or null if not found
   */
  public ToDoItem updateToDoItem(ToDoItem updatedItem) {
    if (updatedItem == null || updatedItem.getId() == null) {
      return null;
    }
    for (int i = 0; i < items.size(); i++) {
      ToDoItem existing = items.get(i);
      if (updatedItem.getId().equals(existing.getId())) {
        // Update fields
        existing.setDescription(updatedItem.getDescription());
        existing.setDueDate(updatedItem.getDueDate());
        existing.setPriority(updatedItem.getPriority());
        existing.setCategory(updatedItem.getCategory());
        existing.setCompleted(updatedItem.isCompleted());
        return existing;
      }
    }
    return null;
  }

  /**
   * Delete a ToDoItem by ID.
   * Returns true if deletion occurred, false if no item with the ID exists.
   *
   * @param id ID of the ToDoItem to delete
   * @return boolean indicating success
   */
  public boolean deleteToDoItem(Long id) {
    if (id == null) {
      return false;
    }
    for (int i = 0; i < items.size(); i++) {
      if (id.equals(items.get(i).getId())) {
        items.remove(i);
        return true;
      }
    }
    return false;
  }
}
