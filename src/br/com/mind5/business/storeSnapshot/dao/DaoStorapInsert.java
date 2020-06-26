package br.com.mind5.business.storeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStorapInsert implements DaoStmtExecV2<StorapInfo> {
	private DaoStmtExecV2<StorapInfo> helper;
	
	
	public DaoStorapInsert(List<DaoStmtExecOption<StorapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStorapInsertSingle.class, StorapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
