package com.hanboard.source;

public class HandleDataSource {
    private static final ThreadLocal<String> holder = new ThreadLocal();

    public HandleDataSource() {
    }

    public static void putDataSource(String dataSource) {
        holder.set(dataSource);
    }

    public static String getDataSource() {
        return (String)holder.get();
    }

    public static void removeDataSource() {
        holder.remove();
    }
}