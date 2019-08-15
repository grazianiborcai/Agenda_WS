package br.com.gda.business.customerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CusnapInsert implements DaoStmtExec<CusnapInfo> {
	private DaoStmtExec<CusnapInfo> helper;
	
	
	public CusnapInsert(List<DaoStmtExecOption<CusnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusnapInsertSingle.class, CusnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusnapInfo> getResultset() {
		return helper.getResultset();
	}
}
