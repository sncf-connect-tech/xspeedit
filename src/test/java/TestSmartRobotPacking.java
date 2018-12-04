import com.ouisncf.packaging.service.PackagingRobot;
import com.ouisncf.packaging.service.SmartPackingRobot;
import com.ouisncf.packaging.util.CommonUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSmartRobotPacking {

    private static final int MAX_BOX_SIZE = 10;

    @Test
    public void testInputIsNull() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot(null);
        assertEquals(smartPackingRobot.packReceivedItems(), CommonUtil.INPUT_MISSING);
    }

    @Test
    public void testInputIsEmpty() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("");
        assertEquals(smartPackingRobot.packReceivedItems(), CommonUtil.INPUT_MISSING);
    }

    @Test
    public void testInputContainsNoNumericValues() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("7621x854");
        assertEquals(smartPackingRobot.packReceivedItems(), CommonUtil.NO_NUMERIC_INPUT);
    }

    @Test
    public void testInputWithOnlyOneValue() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("6");
        assertEquals(smartPackingRobot.packReceivedItems(), "6");
    }

    @Test
    public void testInputWithSmallSizeItems() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("1111111111");
        assertEquals(smartPackingRobot.packReceivedItems(), "1111111111");
    }

    @Test
    public void testInputWithMiddleSizeItems() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("654");
        assertEquals(smartPackingRobot.packReceivedItems(), "64/5");
    }

    @Test
    public void testInputWithBigSizeItems() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("99");
        assertEquals(smartPackingRobot.packReceivedItems(), "9/9");
    }

    @Test
    public void testInputWithReverseOrderedItems() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("987654321");
        assertEquals(smartPackingRobot.packReceivedItems(), "91/82/73/64/5");
    }

    @Test
    public void testInputWithXSpeedItExample() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("163841689525773");
        assertEquals(smartPackingRobot.packReceivedItems(), "163/82/46/19/8/55/73/7");
    }

    @Test
    public void testIfResultsDoNotExceedBoxMaxSize() {
        PackagingRobot smartPackingRobot = new SmartPackingRobot("1631689525773");
        String result = smartPackingRobot.packReceivedItems();
        String[] boxes = result.split("/");
        boolean haveInconsistentBox = false;
        for (String box : boxes) {
            int sumSize = 0;
            for (char itemChar : box.toCharArray()) {
                sumSize += Character.getNumericValue(itemChar);
            }
            if (sumSize > MAX_BOX_SIZE) {
                haveInconsistentBox = true;
                break;
            }
        }
        assertTrue(!haveInconsistentBox);
    }
}
