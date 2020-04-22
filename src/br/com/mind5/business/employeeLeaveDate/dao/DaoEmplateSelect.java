package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmplateSelect implements DaoStmtExecV2<EmplateInfo> {
	private DaoStmtExecV2<EmplateInfo> helper;
	
	
	public DaoEmplateSelect(List<DaoStmtExecOption<EmplateInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmplateSelectSingle.class, EmplateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplateInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
