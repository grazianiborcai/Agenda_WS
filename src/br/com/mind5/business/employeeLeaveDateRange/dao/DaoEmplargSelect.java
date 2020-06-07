package br.com.mind5.business.employeeLeaveDateRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmplargSelect implements DaoStmtExecV2<EmplargInfo> {
	private DaoStmtExecV2<EmplargInfo> helper;
	
	
	public DaoEmplargSelect(List<DaoStmtExecOption<EmplargInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmplargSelectSingle.class, EmplargInfo.class);
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
