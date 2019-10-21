package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
