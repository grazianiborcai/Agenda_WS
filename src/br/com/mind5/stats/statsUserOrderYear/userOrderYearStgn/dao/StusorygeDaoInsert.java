package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;

public final class StusorygeDaoInsert implements DaoStmtExec<StusorygeInfo> {
	private DaoStmtExec<StusorygeInfo> helper;
	
	
	public StusorygeDaoInsert(List<DaoStmtExecOption<StusorygeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StusorygeDaoInsertSingle.class, StusorygeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusorygeInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
