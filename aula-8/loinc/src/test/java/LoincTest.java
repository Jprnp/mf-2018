import com.github.jprnp.loinc.Loinc;
import com.github.jprnp.loinc.LoincUtil;
import org.junit.Test;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoincTest {
    @Test
    public void recuperarPorLoincNumWildcardRetornarMaisDeUm() {
        try {
            ArrayList<Loinc> result = LoincUtil.getLikeLoincNum("-1");
            for (Loinc r : result) {
                System.out.println(r.getLoincNum());
                Assert.assertTrue(r.getLoincNum().contains("-1"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void recuperarPorLoincNumSomenteUm() {
        try {
            Loinc result = LoincUtil.getByLoincNum("10032-1");
            System.out.println(result.getLoincNum());
            Assert.assertEquals(result.getLoincNum(), "10032-1");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void recuperarPorClassType() {
        try {
            ArrayList<Loinc> result = LoincUtil.getByClassType(1);
            for (Loinc r : result) {
                System.out.println(r.getClassType());
                Assert.assertEquals(r.getClassType(), 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
