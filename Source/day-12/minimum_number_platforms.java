import java.util.Arrays;

class Solution {
    public static int calculateMinPlatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);

        int platformsNeeded = 1;
        int maxPlatforms = 1;
        int arrivalIndex = 1;
        int departureIndex = 0;

        while (arrivalIndex < n) {
            if (at[arrivalIndex] <= dt[departureIndex]) {
                platformsNeeded++;
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
                arrivalIndex++;
            } else {
                platformsNeeded--;
                departureIndex++;
            }
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arrivalTimes = {900, 940, 950, 1100, 1500, 1800};
        int[] departureTimes = {910, 1200, 1120, 1130, 1900, 2000};
        int numberOfTrains = 6;

        int minPlatforms = calculateMinPlatforms(arrivalTimes, departureTimes, numberOfTrains);

        System.out.println("Minimum number of platforms needed: " + minPlatforms);
    }
}
