package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MonthSelect implements DaoStmtExec_<MonthInfo> {
	private DaoStmtExec_<MonthInfo> helper;
	
	
	public MonthSelect(List<DaoStmtExecOption<MonthInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MonthSelectSingle.class, MonthInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MonthInfo> getResultset() {
		return helper.getResultset();
	}
}
