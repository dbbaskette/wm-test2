package com.block.todo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    private final Map<Long, ToDoItem> store = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public ToDoItem create(ToDoItem item) {
        Long id = nextId.getAndIncrement();
        item.setId(id);
        store.put(id, item);
        return item;
    }

    public List<ToDoItem> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<ToDoItem> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<ToDoItem> update(Long id, ToDoItem item) {
        if (!store.containsKey(id)) {
            return Optional.empty();
        }
        item.setId(id);
        store.put(id, item);
        return Optional.of(item);
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
