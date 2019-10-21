package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
