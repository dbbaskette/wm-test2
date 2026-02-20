import React from 'react';
import ToDoList from './ToDoList';
import ToDoForm from './ToDoForm';

// Main entry point for the React frontend
const App = () => {
  const [items, setItems] = React.useState([]);
  const [error, setError] = React.useState(null);

  // Fetch existing to-dos on mount
  React.useEffect(() => {
    fetch('/api/todos')
      .then(res => {
        if (!res.ok) throw new Error('Failed to fetch to-dos');
        return res.json();
      })
      .then(data => setItems(data))
      .catch(err => setError(err.message));
  }, []);

  // Add a new to-do
  const addTodo = async (todo) => {
    const res = await fetch('/api/todos', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(todo),
    });
    if (!res.ok) {
      const err = await res.text();
      throw new Error(err || 'Failed to add todo');
    }
    const created = await res.json();
    setItems(prev => [...prev, created]);
  };

  // Update a to-do
  const updateTodo = async (id, updated) => {
    const res = await fetch(`/api/todos/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updated),
    });
    if (!res.ok) {
      const err = await res.text();
      throw new Error(err || 'Failed to update todo');
    }
    const updatedItem = await res.json();
    setItems(prev => prev.map(it => it.id === id ? updatedItem : it));
  };

  // Delete a to-do
  const deleteTodo = async (id) => {
    const res = await fetch(`/api/todos/${id}`, { method: 'DELETE' });
    if (!res.ok) {
      const err = await res.text();
      throw new Error(err || 'Failed to delete todo');
    }
    setItems(prev => prev.filter(it => it.id !== id));
  };

  // Handlers to pass down
  const handleToggleComplete = (id, updated) => updateTodo(id, updated);
  const handleDelete = (id) => deleteTodo(id);

  return (
    <div style={styles.app}>
      <h1 style={styles.header}>To-Do Manager</h1>
      {error && (
        <div style={styles.error}>{error}</div>
      )}
      <ToDoForm onAdd={addTodo} />
      <ToDoList items={items} onToggleComplete={handleToggleComplete} onDelete={handleDelete} onError={setError} />
    </div>
  );
};

const styles = {
  app: {
    fontFamily: 'Arial, sans-serif',
    padding: '20px',
  },
  header: {
    marginBottom: '16px',
  },
  error: {
    color: 'red',
    marginBottom: '8px',
  },
};

export default App;
