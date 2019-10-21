package br.com.mind5.business.customerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CusnapSelect implements DaoStmtExec<CusnapInfo> {
	private DaoStmtExec<CusnapInfo> helper;
	
	
	public CusnapSelect(List<DaoStmtExecOption<CusnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusnapSelectSingle.class, CusnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusnapInfo> getResultset() {
		return helper.getResultset();
	}
}
