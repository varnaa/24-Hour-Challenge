package Easy;

import java.util.Arrays;

/**
 * @author swethavarnaa
 */
public class MaxUnitsTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Base Case
        if (boxTypes == null || boxTypes.length == 0 || truckSize == 0) {
            return 0;
        }

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnits = 0;

        for (int[] boxType : boxTypes) {
            int possibleUnits = boxType[0] * boxType[1];
            truckSize -= boxType[0];
            maxUnits += possibleUnits;
            if (truckSize <= 0) {
                int toRemove = Math.abs(truckSize * boxType[1]);
                maxUnits -= toRemove;
                return maxUnits;
            }
        }

        return maxUnits;
    }
}
