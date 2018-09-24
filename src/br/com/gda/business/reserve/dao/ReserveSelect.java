package br.com.gda.business.reserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class ReserveSelect implements DaoStmtExec<ReserveInfo> {
	private DaoStmtExec<ReserveInfo> helper;
	
	
	public ReserveSelect(List<DaoStmtExecOption<ReserveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, ReserveSelectSingle.class, ReserveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ReserveInfo> getResultset() {
		return helper.getResultset();
	}
}
