package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;

public final class CustamonagrDaoInsert implements DaoStmtExec<CustamonagrInfo> {
	private DaoStmtExec<CustamonagrInfo> helper;
	
	
	public CustamonagrDaoInsert(List<DaoStmtExecOption<CustamonagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CustamonagrDaoInsertSingle.class, CustamonagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CustamonagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
