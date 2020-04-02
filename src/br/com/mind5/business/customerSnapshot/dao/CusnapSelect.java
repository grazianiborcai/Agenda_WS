package br.com.mind5.business.customerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CusnapSelect implements DaoStmtExec_<CusnapInfo> {
	private DaoStmtExec_<CusnapInfo> helper;
	
	
	public CusnapSelect(List<DaoStmtExecOption<CusnapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CusnapSelectSingle.class, CusnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusnapInfo> getResultset() {
		return helper.getResultset();
	}
}
