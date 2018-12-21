/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package singh.mahabir.allinone;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Mahabir Singh
 *
 */
public class RandonTest {

    @Test
    public void tst() throws CloneNotSupportedException {
        final StringTest t1 = new StringTest();
        final StringTest t2 = new StringTest(10);
        assertFalse(t1.equals(""));
        assertTrue(t1.equals(t2));

        final StringTest t3 = (StringTest) t2.clone();
        assertTrue(t2.equals(t3));
        System.err.println(t2 + "  " + t3);
        assertFalse(t2 == t3);
        assertTrue(t2.name == t3.name);
    }

}

class StringTest implements Cloneable {
    private final int x;
    String name;

    StringTest() {
        x = 10;
        name = "mahabir";
    }

    StringTest(int x) {
        this.x = x;
        name = "mahabir";
    }

    @Override
    public boolean equals(Object o) {

        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        return this.x == ((StringTest) o).x;

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // shallow cloning
        // return super.clone();

        // deep cloning
        final StringTest ob = (StringTest) super.clone();
        ob.name = ob.name;
        return ob;
    }
}
