class UserRegistry {
	// List<User> getUsers(), void withUsers(User), ...
	User getOrCreate(int id) {
		// (1)
		for (final User user : this.getUsers()) {
			if (user.getId() == id) {
				return user;
			}
		}
		// (2)
		User newUser = new User();
		newUser.setId(id);
		this.withUsers(newUser);
		return newUser;
	}
}
