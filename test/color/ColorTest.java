package color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorTest {

    private Color color;
    @BeforeEach
    public void setUp() {
        color = new Color(100, 50, 200);
    }

    @AfterEach
    public void tearDown() {
        color = null;
    }

    @Test
    public void testConstructor() {
        assertEquals(100, color.getRed(), "Red value should be 100");
        assertEquals(50, color.getGreen(), "Green value should be 50");
        assertEquals(200, color.getBlue(), "Blue value should be 200");
    }

    @Test
    public void testRangeMaxColorRed() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(256, 50, 200);
        });
    }
    @Test
    public void testRangeMaxColorGreen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(100, 256, 200);
        });
    }
    @Test
    public void testRangeMaxColorBlue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(100, 50, 256);
        });
    }
    @Test
    public void testRangeMinColorRed() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(-1, 50, 200);
        });
    }
    @Test
    public void testRangeMinColorGreen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(100, -1, 200);
        });
    }
    @Test
    public void testRangeMinColorBlue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(100, 50, -1);
        });
    }

    @Test
    public void testHexConstructor() {
        color = new Color("#FF01FF");
        assertEquals("#FF01FF", color.getHexValue());
        assertEquals(255, color.getRed());
        assertEquals(1, color.getGreen());
        assertEquals(255, color.getBlue());
    }

    @Test
    public void testHexConstructorInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color("#FF01F");
        });
    }

    @Test
    public void testGetRed() {
        assertEquals(100, color.getRed(), "Red value should be 100");
        assertEquals(50, color.getGreen(), "Green value should be 50");
        assertEquals(200, color.getBlue(), "Blue value should be 200");

        assertEquals("#6432C8", color.getHexValue(), "Hex value should be #6432C8");
    }
    @Test
    public void testGetGreen() {
        assertEquals(50, color.getGreen(), "Green value should be 50");
        assertEquals(200, color.getBlue(), "Blue value should be 200");
        assertEquals(100, color.getRed(), "Red value should be 100");

        assertEquals("#6432C8", color.getHexValue(), "Hex value should be #6432C8");
    }
    @Test
    public void testGetBlue() {
        assertEquals(200, color.getBlue(), "Blue value should be 200");
        assertEquals(100, color.getRed(), "Red value should be 100");
        assertEquals(50, color.getGreen(), "Green value should be 50");

        assertEquals("#6432C8", color.getHexValue(), "Hex value should be #6432C8");
    }

    @Test
    public void testGetHexValue() {
        assertEquals("#6432C8", color.getHexValue(), "Hex value should be #6432C8");
        assertEquals(100, color.getRed(), "Red value should be 100");
        assertEquals(50, color.getGreen(), "Green value should be 50");
        assertEquals(200, color.getBlue(), "Blue value should be 200");
    }

    @Test
    public void testSetRed() {
        color.setRed(255);
        assertEquals(255, color.getRed(), "Red value should be 255");
        assertEquals(50, color.getGreen(), "Green value should be 50");
        assertEquals(200, color.getBlue(), "Blue value should be 200");

        assertEquals("#FF32C8", color.getHexValue(), "Hex value should be #FF32C8");
    }

    @Test
    public void testSetRedInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRed(256);
        });
        assertEquals(100, color.getRed());
    }

    @Test
    public void testSetGreen() {
        color.setGreen(255);
        assertEquals(255, color.getGreen(), "Green value should be 255");
        assertEquals(100, color.getRed(), "Red value should be 100");
        assertEquals(200, color.getBlue(), "Blue value should be 200");

        assertEquals("#64FFC8", color.getHexValue(), "Hex value should be #64FFC8");
    }

    @Test
    public void testSetGreenInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setGreen(256);
        });
        assertEquals(50, color.getGreen());
    }

    @Test
    public void testSetBlue() {
        color.setBlue(255);
        assertEquals(255, color.getBlue(), "Blue value should be 255");
        assertEquals(100, color.getRed(), "Red value should be 100");
        assertEquals(50, color.getGreen(), "Green value should be 50");

        assertEquals("#6432FF", color.getHexValue(), "Hex value should be #6432FF");
    }

    @Test
    public void testSetBlueInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setBlue(256);
        });
        assertEquals(200, color.getBlue());
    }

    @Test
    public void testSetHexValue() {
        color.setHexValue("#FF01FF");
        assertEquals("#FF01FF", color.getHexValue());
        assertEquals(255, color.getRed());
        assertEquals(1, color.getGreen());
        assertEquals(255, color.getBlue());
    }

    @Test
    public void testSetHexValueInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setHexValue("#FF01F");
        });
        assertEquals("#6432C8", color.getHexValue());
    }

    @Test
    public void testToString() {
        assertEquals("[value=#6432C8, r=100, g=50, b=200]", color.toString());
    }

}
