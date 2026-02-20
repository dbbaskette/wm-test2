import React from 'react';
import ToDoItem from './ToDoItem';

// Displays a list of to-do items
const ToDoList = ({ items, onToggleComplete, onDelete, onError }) => {
  if (!items || items.length === 0) {
    return <div style={styles.empty}>No to-do items. Add one below.</div>;
  }

  return (
    <div style={styles.list}>
      {items.map(item => (
        <ToDoItem
          key={item.id}
          item={item}
          onToggleComplete={onToggleComplete}
          onDelete={onDelete}
        />
      ))}
    </div>
  );
};

const styles = {
  list: {
    display: 'flex',
    flexDirection: 'column',
    gap: '12px',
    marginTop: '16px',
  },
  empty: {
    fontStyle: 'italic',
    color: '#666',
  },
};

export default ToDoList;
