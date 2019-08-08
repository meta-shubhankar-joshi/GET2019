class UseQueue implements Queue {
	private Object[] queue;
	private int start;
	private int end;
	private int sizeOfQueue;
	private boolean isFull = false;
	private boolean isEmpty = true;

	/**
	 * Constructor to initialize the Queue size
	 */
	public UseQueue(int sizeOfQueue) {
		this.sizeOfQueue = sizeOfQueue;
		queue = new Object[sizeOfQueue];
	}         

	/**
	 * Method to insert item into Queue Parameter itemToInsert is item of Object
	 * type Returns true if item inserted otherwise false
	 */
	public boolean addItem(Object itemToInsert) {
		if (!isFull) {
			queue[end] = itemToInsert;
			end++;
			if (end == sizeOfQueue)
				end = -1;
			if (isEmpty) {
				isEmpty = false;
			}
			if (end + 1 == start) {
				isFull = true;
			}
			return true;
		} else
			return false;
	}

	/**
	 * Method to delete item from Queue Returns item of Object type if there is
	 * exists otherwise null if Queue is empty
	 */
	public Object deleteItem() {
		if (!isEmpty) {
			int tempStart = start;
			start++;
			if (start == sizeOfQueue)
				start = 0;
			if (isFull) {
				isFull = false;
				end++;
			}
			if (start == end) {
				isEmpty = true;
			}
			return queue[tempStart];
		} else
			return null;
	}

	/**
	 * Method checks whether Queue is empty or not Returns true if Queue is
	 * empty otherwise false
	 */
	public boolean isEmpty() {
		return isEmpty;
	}

	/**
	 * Method checks whether Queue is full or not Returns true if Queue is full
	 * otherwise false
	 */
	public boolean isFull() {
		return isFull;
	}
}