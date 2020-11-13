package br.com.mind5.business.employeeLeaveDateRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmplargSelect implements DaoStmtExec<EmplargInfo> {
	private DaoStmtExec<EmplargInfo> helper;
	
	
	public DaoEmplargSelect(List<DaoStmtExecOption<EmplargInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmplargSelectSingle.class, EmplargInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplargInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
