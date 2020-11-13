package br.com.mind5.business.phoneDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPhonaultSelect implements DaoStmtExec<PhonaultInfo> {
	private DaoStmtExec<PhonaultInfo> helper;
	
	
	public DaoPhonaultSelect(List<DaoStmtExecOption<PhonaultInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPhonaultSelectSingle.class, PhonaultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonaultInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
