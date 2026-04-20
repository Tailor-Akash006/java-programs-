package Strings;



public class PerformanceTest {
    public static void main(String[] args) {
        // Test StringBuffer Performance
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("Java");
        for (int i = 0; i < 100000; i++) { // Increased iterations to see a clearer difference
            sb.append("Tpoint");
        }
        System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");

        // Test StringBuilder Performance
        startTime = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder("Java");
        for (int i = 0; i < 100000; i++) {
            sb2.append("Tpoint");
        }
        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
