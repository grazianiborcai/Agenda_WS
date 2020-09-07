package br.com.mind5.business.phoneDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoPhonaultSelect implements DaoStmtExecV2<PhonaultInfo> {
	private DaoStmtExecV2<PhonaultInfo> helper;
	
	
	public DaoPhonaultSelect(List<DaoStmtExecOption<PhonaultInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPhonaultSelectSingle.class, PhonaultInfo.class);
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
