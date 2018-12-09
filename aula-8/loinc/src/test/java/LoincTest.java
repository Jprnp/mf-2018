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
}
