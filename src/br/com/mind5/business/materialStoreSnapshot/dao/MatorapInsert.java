package br.com.mind5.business.materialStoreSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatorapInsert implements DaoStmtExec<MatorapInfo> {
	private DaoStmtExec<MatorapInfo> helper;
	
	
	public MatorapInsert(List<DaoStmtExecOption<MatorapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatorapInsertSingle.class, MatorapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatorapInfo> getResultset() {
		return helper.getResultset();
	}
}
