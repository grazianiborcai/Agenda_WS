package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;

public final class CutefiloniveDaoSelect implements DaoStmtExec<CutefiloniveInfo> {
	private DaoStmtExec<CutefiloniveInfo> helper;
	
	
	public CutefiloniveDaoSelect(List<DaoStmtExecOption<CutefiloniveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CutefiloniveDaoSelectSingle.class, CutefiloniveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CutefiloniveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
