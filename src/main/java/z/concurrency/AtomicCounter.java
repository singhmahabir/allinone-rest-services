/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.concurrency;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Mahabir Singh
 *
 *         Non-blocking Algorithms
 */
public class AtomicCounter {
	private final AtomicLong count = new AtomicLong(0);

	public void inc() {
		boolean updated = false;
		while (!updated) {
			final long prevCount = this.count.get();
			updated = this.count.compareAndSet(prevCount, prevCount + 1);
		}
	}

	public long count() {
		return this.count.get();
	}
}