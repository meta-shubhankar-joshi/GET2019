public class CheckUseQueue {
	public static void main(String args[]) {
		UseQueue queue = new UseQueue(3);
		// checking for empty
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());

		System.out.println("\n\n" + queue.addItem(1));
		System.out.println(queue.isEmpty());

		// to full
		System.out.println(queue.addItem(2));
		System.out.println(queue.addItem(3));
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		System.out.println(queue.addItem(4));

		// deleting
		System.out.println("\n\nremoving\n" + queue.isFull());
		System.out.println(queue.deleteItem());
		System.out.println(queue.deleteItem());
		System.out.println(queue.deleteItem());
		System.out.println(queue.deleteItem());
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
	}
}