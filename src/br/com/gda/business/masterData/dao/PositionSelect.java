package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PositionSelect implements DaoStmtExec<PositionInfo> {
	private DaoStmtExec<PositionInfo> helper;
	
	
	public PositionSelect(List<DaoStmtExecOption<PositionInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PositionSelectSingle.class, PositionInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PositionInfo> getResultset() {
		return helper.getResultset();
	}
}
