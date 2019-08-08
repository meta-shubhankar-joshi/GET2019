public interface Queue {
	/**
	 * Method to insert item into Queue Parameter itemToInsert is item of Object
	 * type & this method Returns true if item inserted otherwise false
	 */
	boolean addItem(Object itemToInsert);

	/**
	 * Method to delete item from Queue
	 * Returns item of Object type if there item
	 * exists otherwise null if Queue is empty
	 */
	Object deleteItem();

	/**
	 * Method checks whether Queue is empty or not Returns true if Queue is
	 * empty otherwise false
	 */
	boolean isEmpty();

	/**
	 * Method checks whether Queue is full or not Returns true if Queue is full
	 * otherwise false
	 */
	boolean isFull();
}