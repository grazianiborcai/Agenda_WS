package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatUnitSelect implements DaoStmtExec<MatUnitInfo> {
	private DaoStmtExec<MatUnitInfo> helper;
	
	
	public MatUnitSelect(List<DaoStmtExecOption<MatUnitInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatUnitSelectSingle.class, MatUnitInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatUnitInfo> getResultset() {
		return helper.getResultset();
	}
}
