package br.com.mind5.business.feeDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class FeedefSelect implements DaoStmtExec_<FeedefInfo> {
	private DaoStmtExec_<FeedefInfo> helper;
	
	
	public FeedefSelect(List<DaoStmtExecOption<FeedefInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, FeedefSelectSingle.class, FeedefInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeedefInfo> getResultset() {
		return helper.getResultset();
	}
}
