package br.avcaliani.cache.util;

public class TimeUtil {

    /**
     * Thread sleep.
     *
     * @param delay Time to sleep.
     */
    public static void sleep(long delay) {
        try {
            if (delay <= 0) return;
            Thread.sleep(delay);
        } catch (Exception ex) {
            /* There is nothing to be done now */
        }
    }

    private TimeUtil() { /* Avoiding new instances */ }
}
