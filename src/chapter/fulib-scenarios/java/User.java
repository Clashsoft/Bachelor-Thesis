package org.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class User {
	public static final String PROPERTY_id = "id";

	private int id;

	public int getId() {
		return id;
	}

	public User setId(int value) {
		if (value != this.id) {
			int oldValue = this.id;
			this.id = value;
			firePropertyChange("id", oldValue, value);
		}
		return this;
	}

	public static final String PROPERTY_registry = "registry";

	private UserRegistry registry = null;

	public UserRegistry getRegistry() {
		return this.registry;
	}

	public User setRegistry(UserRegistry value) {
		if (this.registry != value) {
			UserRegistry oldValue = this.registry;
			if (this.registry != null) {
				this.registry = null;
				oldValue.withoutUsers(this);
			}
			this.registry = value;
			if (value != null) {
				value.withUsers(this);
			}
			firePropertyChange("registry", oldValue, value);
		}
		return this;
	}

	protected PropertyChangeSupport listeners = null;

	public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		if (listeners != null) {
			listeners.firePropertyChange(propertyName, oldValue, newValue);
			return true;
		}
		return false;
	}

	public boolean addPropertyChangeListener(PropertyChangeListener listener) {
		if (listeners == null) {
			listeners = new PropertyChangeSupport(this);
		}
		listeners.addPropertyChangeListener(listener);
		return true;
	}

	public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		if (listeners == null) {
			listeners = new PropertyChangeSupport(this);
		}
		listeners.addPropertyChangeListener(propertyName, listener);
		return true;
	}

	public boolean removePropertyChangeListener(PropertyChangeListener listener) {
		if (listeners != null) {
			listeners.removePropertyChangeListener(listener);
		}
		return true;
	}

	public boolean removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		if (listeners != null) {
			listeners.removePropertyChangeListener(propertyName, listener);
		}
		return true;
	}

	public void removeYou() {
		this.setRegistry(null);
	}
}
