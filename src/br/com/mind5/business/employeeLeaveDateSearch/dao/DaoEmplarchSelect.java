package br.com.mind5.business.employeeLeaveDateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmplarchSelect implements DaoStmtExecV2<EmplarchInfo> {
	private DaoStmtExecV2<EmplarchInfo> helper;
	
	
	public DaoEmplarchSelect(List<DaoStmtExecOption<EmplarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmplarchSelectSingle.class, EmplarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
