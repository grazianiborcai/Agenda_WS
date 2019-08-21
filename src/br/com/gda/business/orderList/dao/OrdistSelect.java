package br.com.gda.business.orderList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class OrdistSelect implements DaoStmtExec<OrdistInfo> {
	private DaoStmtExec<OrdistInfo> helper;
	
	
	public OrdistSelect(List<DaoStmtExecOption<OrdistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrdistSelectSingle.class, OrdistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdistInfo> getResultset() {
		return helper.getResultset();
	}
}
