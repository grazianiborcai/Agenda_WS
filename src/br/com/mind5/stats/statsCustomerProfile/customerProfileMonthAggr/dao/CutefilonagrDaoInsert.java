package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;

public final class CutefilonagrDaoInsert implements DaoStmtExec<CutefilonagrInfo> {
	private DaoStmtExec<CutefilonagrInfo> helper;
	
	
	public CutefilonagrDaoInsert(List<DaoStmtExecOption<CutefilonagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CutefilonagrDaoInsertSingle.class, CutefilonagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CutefilonagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
