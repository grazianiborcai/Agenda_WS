package br.com.mind5.business.phoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPhonarchSelect implements DaoStmtExec<PhonarchInfo> {
	private DaoStmtExec<PhonarchInfo> helper;
	
	
	public DaoPhonarchSelect(List<DaoStmtExecOption<PhonarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPhonarchSelectSingle.class, PhonarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
