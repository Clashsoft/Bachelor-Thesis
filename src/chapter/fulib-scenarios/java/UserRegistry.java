package org.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserRegistry
{
	public static final java.util.ArrayList<User> EMPTY_users = new java.util.ArrayList<User>()
	{
		@Override
		public boolean add(User value)
		{
			throw new UnsupportedOperationException("No direct add! Use xy.withUsers(obj)");
		}
	};

	public static final String PROPERTY_users = "users";

	private java.util.ArrayList<User> users = null;

	public java.util.ArrayList<User> getUsers()
	{
		if (this.users == null)
		{
			return EMPTY_users;
		}

		return this.users;
	}

	public UserRegistry withUsers(Object... value)
	{
		if (value == null)
			return this;
		for (Object item : value)
		{
			if (item == null)
				continue;
			if (item instanceof java.util.Collection)
			{
				for (Object i : (java.util.Collection) item)
				{
					this.withUsers(i);
				}
			}
			else if (item instanceof User)
			{
				if (this.users == null)
				{
					this.users = new java.util.ArrayList<User>();
				}
				if (!this.users.contains(item))
				{
					this.users.add((User) item);
					((User) item).setRegistry(this);
					firePropertyChange("users", null, item);
				}
			}
			else
				throw new IllegalArgumentException();
		}
		return this;
	}

	public UserRegistry withoutUsers(Object... value)
	{
		if (this.users == null || value == null)
			return this;
		for (Object item : value)
		{
			if (item == null)
				continue;
			if (item instanceof java.util.Collection)
			{
				for (Object i : (java.util.Collection) item)
				{
					this.withoutUsers(i);
				}
			}
			else if (item instanceof User)
			{
				if (this.users.contains(item))
				{
					this.users.remove((User) item);
					((User) item).setRegistry(null);
					firePropertyChange("users", item, null);
				}
			}
		}
		return this;
	}

	public User getOrCreate(int id)
	{
		// (1)
		for (final User user : this.getUsers())
		{
			if (user.getId() == id)
			{
				return user;
			}
		}
		// (2)
		User newUser = new User();
		newUser.setId(id);
		this.withUsers(newUser);
		return newUser;
	}

	protected PropertyChangeSupport listeners = null;

	public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
	{
		if (listeners != null)
		{
			listeners.firePropertyChange(propertyName, oldValue, newValue);
			return true;
		}
		return false;
	}

	public boolean addPropertyChangeListener(PropertyChangeListener listener)
	{
		if (listeners == null)
		{
			listeners = new PropertyChangeSupport(this);
		}
		listeners.addPropertyChangeListener(listener);
		return true;
	}

	public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
	{
		if (listeners == null)
		{
			listeners = new PropertyChangeSupport(this);
		}
		listeners.addPropertyChangeListener(propertyName, listener);
		return true;
	}

	public boolean removePropertyChangeListener(PropertyChangeListener listener)
	{
		if (listeners != null)
		{
			listeners.removePropertyChangeListener(listener);
		}
		return true;
	}

	public boolean removePropertyChangeListener(String propertyName, PropertyChangeListener listener)
	{
		if (listeners != null)
		{
			listeners.removePropertyChangeListener(propertyName, listener);
		}
		return true;
	}

	public void removeYou()
	{
		this.withoutUsers(this.getUsers().clone());
	}
}
