package br.com.mind5.business.calendarMonthSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class CalontharchDaoSelect implements DaoStmtExec<CalontharchInfo> {
	private DaoStmtExec<CalontharchInfo> helper;
	
	
	public CalontharchDaoSelect(List<DaoStmtExecOption<CalontharchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CalontharchDaoSelectSingle.class, CalontharchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<CalontharchInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();
	}
}
