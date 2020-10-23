package br.com.mind5.security.userSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class DaoUserapInsert implements DaoStmtExecV2<UserapInfo> {
	private DaoStmtExecV2<UserapInfo> helper;
	
	
	public DaoUserapInsert(List<DaoStmtExecOption<UserapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoUserapInsertSingle.class, UserapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
