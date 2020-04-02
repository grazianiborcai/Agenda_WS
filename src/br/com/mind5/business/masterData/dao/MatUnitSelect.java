package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatUnitSelect implements DaoStmtExec_<MatUnitInfo> {
	private DaoStmtExec_<MatUnitInfo> helper;
	
	
	public MatUnitSelect(List<DaoStmtExecOption<MatUnitInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatUnitSelectSingle.class, MatUnitInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatUnitInfo> getResultset() {
		return helper.getResultset();
	}
}
