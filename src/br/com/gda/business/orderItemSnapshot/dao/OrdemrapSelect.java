package br.com.gda.business.orderItemSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class OrdemrapSelect implements DaoStmtExec<OrdemrapInfo> {
	private DaoStmtExec<OrdemrapInfo> helper;
	
	
	public OrdemrapSelect(List<DaoStmtExecOption<OrdemrapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrdemrapSelectSingle.class, OrdemrapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdemrapInfo> getResultset() {
		return helper.getResultset();
	}
}
