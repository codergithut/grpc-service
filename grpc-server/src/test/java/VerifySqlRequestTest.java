import grpc.search.oauth.server.s.model.SqlSearchField;
import grpc.search.oauth.server.s.server.impl.VerifySqlRequestImpl;
import org.junit.Test;

import java.util.List;

/**
 * Created by tianjian on 2019/7/15.
 */
public class VerifySqlRequestTest {

    @Test
    public void verifySqlReqest() {
        VerifySqlRequestImpl verifySqlRequest = new VerifySqlRequestImpl();
        List<SqlSearchField> datas = verifySqlRequest.parseSql("with\n" +
                "cr as\n" +
                "(\n" +
                "select CountryRegionCode from person.CountryRegion where Name like 'C%'\n" +
                ")\n" +
                "select * from person.StateProvince where CountryRegionCode in (select * from cr)");
        for(SqlSearchField sqlSearchField : datas) {
            System.out.println(sqlSearchField.getTableName());
        }


    }
}
