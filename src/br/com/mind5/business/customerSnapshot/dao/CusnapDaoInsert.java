package br.com.mind5.business.customerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class CusnapDaoInsert implements DaoStmtExec<CusnapInfo> {
	private DaoStmtExec<CusnapInfo> helper;
	
	
	public CusnapDaoInsert(List<DaoStmtExecOption<CusnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusnapDaoInsertSingle.class, CusnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
