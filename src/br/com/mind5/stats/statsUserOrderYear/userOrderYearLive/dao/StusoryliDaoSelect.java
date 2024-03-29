package br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;

public final class StusoryliDaoSelect implements DaoStmtExec<StusoryliInfo> {
	private DaoStmtExec<StusoryliInfo> helper;
	
	
	public StusoryliDaoSelect(List<DaoStmtExecOption<StusoryliInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StusoryliDaoSelectSingle.class, StusoryliInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusoryliInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
