package br.com.mind5.business.employeeList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmplisSelect implements DaoStmtExec<EmplisInfo> {
	private DaoStmtExec<EmplisInfo> helper;
	
	
	public DaoEmplisSelect(List<DaoStmtExecOption<EmplisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmplisSelectSingle.class, EmplisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplisInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
