package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class GenderSelect implements DaoStmtExec<GenderInfo> {
	private DaoStmtExec<GenderInfo> helper;
	
	
	public GenderSelect(List<DaoStmtExecOption<GenderInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, GenderSelectSingle.class, GenderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<GenderInfo> getResultset() {
		return helper.getResultset();
	}
}
