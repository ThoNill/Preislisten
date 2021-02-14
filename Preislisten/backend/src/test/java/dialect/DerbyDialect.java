package dialect;

import java.sql.Types;

import org.hibernate.dialect.DerbyTenSevenDialect;

public class DerbyDialect extends DerbyTenSevenDialect {
    public DerbyDialect() {
        super();
        registerColumnType( Types.CLOB, "clob" );
    }
}
