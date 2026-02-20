import React from 'react';

// Renders a single to-do item with actions to complete or delete
const ToDoItem = ({ item, onToggleComplete, onDelete }) => {
  const toggle = (e) => {
    const updated = { ...item, completed: e.target.checked };
    onToggleComplete && onToggleComplete(item.id, updated);
  };

  const del = () => onDelete && onDelete(item.id);

  const formatDate = (date) => {
    if (!date) return null;
    const d = new Date(date);
    if (isNaN(d)) return date;
    return d.toLocaleDateString(undefined, { year: 'numeric', month: 'short', day: 'numeric' });
  };

  const priorityLabel = (p) => {
    if (!p) return '';
    // Normalize to user-friendly capitalization
    return p.charAt(0) + p.slice(1).toLowerCase();
  };

  return (
    <div style={styles.item}>
      <input type="checkbox" checked={!!item.completed} onChange={toggle} />
      <div style={item.completed ? { ...styles.content, textDecoration: 'line-through' } : styles.content}>
        <div style={styles.title}>{item.title}</div>
        {item.description && <div style={styles.description}>{item.description}</div>}
        <div style={styles.meta}>
          {item.dueDate && <span>Due: {formatDate(item.dueDate)}</span>}
          {item.priority && (
            <span> | Priority: {priorityLabel(item.priority)}</span>
          )}
          {item.category && (
            <span> | Category: {String(item.category)}</span>
          )}
        </div>
      </div>
      <button style={styles.deleteBtn} onClick={del} aria-label="Delete">Delete</button>
    </div>
  );
};

const styles = {
  item: {
    display: 'flex',
    alignItems: 'center',
    padding: '8px 12px',
    border: '1px solid #ccc',
    borderRadius: 4,
  },
  content: {
    display: 'flex',
    flexDirection: 'column',
    marginLeft: 8,
    flex: 1,
  },
  title: {
    fontWeight: 600,
  },
  description: {
    fontSize: 12,
    color: '#555',
  },
  meta: {
    fontSize: 12,
    color: '#666',
    marginTop: 4,
  },
  deleteBtn: {
    background: '#e74c3c',
    color: '#fff',
    border: 'none',
    padding: '6px 12px',
    borderRadius: 4,
    cursor: 'pointer',
  },
};

export default ToDoItem;
