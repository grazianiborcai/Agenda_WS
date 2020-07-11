package br.com.mind5.business.employeeList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmplisSelect implements DaoStmtExecV2<EmplisInfo> {
	private DaoStmtExecV2<EmplisInfo> helper;
	
	
	public DaoEmplisSelect(List<DaoStmtExecOption<EmplisInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmplisSelectSingle.class, EmplisInfo.class);
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
