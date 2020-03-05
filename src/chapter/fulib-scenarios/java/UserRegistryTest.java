import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRegistryTest {
	@Test
	public void getOrCreate() {
		// --- Setup ---
		UserRegistry registry = new UserRegistry();
		User u123 = new User();
		u123.setId(123);
		u123.setRegistry(registry);
		// --- Get Existing ---
		User user = registry.getOrCreate(123);
		assertEquals(user, u123);
		// --- Create New ---
		User newUser = registry.getOrCreate(456);
		assertEquals(newUser.getId(), 456, 0);
	}
}
