import React from 'react';

// Form to add a new to-do item
const ToDoForm = ({ onAdd }) => {
  const [title, setTitle] = React.useState('');
  const [description, setDescription] = React.useState('');
  const [error, setError] = React.useState(null);

  const submit = async (e) => {
    e.preventDefault();
    const trimmed = title.trim();
    if (!trimmed) {
      setError('Title is required');
      return;
    }
    try {
      await onAdd({ title: trimmed, description: description.trim(), completed: false });
      // Reset form on success
      setTitle('');
      setDescription('');
      setError(null);
    } catch (err) {
      setError(err?.message || 'Failed to add todo');
    }
  };

  return (
    <form onSubmit={submit} style={styles.form}>
      <input
        type="text"
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        style={styles.input}
        aria-label="Title"
      />
      <input
        type="text"
        placeholder="Description (optional)"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
        style={styles.input}
        aria-label="Description"
      />
      <button type="submit" style={styles.button}>Add To-Do</button>
      {error && <div style={styles.error}>{error}</div>}
    </form>
  );
};

const styles = {
  form: {
    display: 'flex',
    gap: '8px',
    alignItems: 'center',
    marginTop: '8px',
  },
  input: {
    padding: '8px',
    borderRadius: 4,
    border: '1px solid #ccc',
    minWidth: 180,
  },
  button: {
    padding: '8px 12px',
    background: '#2c7be5',
    color: '#fff',
    border: 'none',
    borderRadius: 4,
    cursor: 'pointer',
  },
  error: {
    marginLeft: 8,
    color: 'red',
  },
};

export default ToDoForm;
