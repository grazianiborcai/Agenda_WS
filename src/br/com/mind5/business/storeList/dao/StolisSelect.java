package br.com.mind5.business.storeList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StolisSelect implements DaoStmtExec_<StolisInfo> {
	private DaoStmtExec_<StolisInfo> helper;
	
	
	public StolisSelect(List<DaoStmtExecOption<StolisInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StolisSelectSingle.class, StolisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StolisInfo> getResultset() {
		return helper.getResultset();
	}
}
