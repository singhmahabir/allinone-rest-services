/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.concurrency;

/**
 * @author Mahabir Singh
 *
 */
public class AtomicInteger {
	public static void main(String[] args) throws InterruptedException {

		final ProcessingThreadWithoutAtomic nonAtomic = new ProcessingThreadWithoutAtomic();
		final Thread task = new Thread(nonAtomic, "nonAtomic-t1");
		task.start();

		final Thread task1 = new Thread(nonAtomic, "nonAtomic-t2");
		task1.start();

		task.join();
		task1.join();

//        final ProcessingThreadWithAtomic atomic = new ProcessingThreadWithAtomic();
//
//        final Thread task2 = new Thread(atomic, "Atomic-t1");
//        task2.start();
//
//        final Thread task3 = new Thread(atomic, "Atomic-t2");
//        task3.start();
//
//        task2.join();
//        task3.join();
	}
}
