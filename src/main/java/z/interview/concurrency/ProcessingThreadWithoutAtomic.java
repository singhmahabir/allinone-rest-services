/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interview.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author Mahabir Singh
 *
 */
public class ProcessingThreadWithoutAtomic implements Runnable {
    private int count;

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        System.out.println(Thread.currentThread().getName() + " entry with iteration " + i + " with value " + getCount());
        try {
            TimeUnit.MILLISECONDS.sleep(i * 1000l);
            // Thread.sleep(i * 1000);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " exisintg  with iteration " + i + " with value " + getCount());
    }

}
