package br.com.mind5.business.storeLeaveDateRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StolargSelect implements DaoStmtExec_<StolargInfo> {
	private DaoStmtExec_<StolargInfo> helper;
	
	
	public StolargSelect(List<DaoStmtExecOption<StolargInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StolargSelectSingle.class, StolargInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StolargInfo> getResultset() {
		return helper.getResultset();
	}
}
