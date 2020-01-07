package br.com.mind5.business.storeLeaveDateRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class StolargSelect implements DaoStmtExec<StolargInfo> {
	private DaoStmtExec<StolargInfo> helper;
	
	
	public StolargSelect(List<DaoStmtExecOption<StolargInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StolargSelectSingle.class, StolargInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StolargInfo> getResultset() {
		return helper.getResultset();
	}
}
