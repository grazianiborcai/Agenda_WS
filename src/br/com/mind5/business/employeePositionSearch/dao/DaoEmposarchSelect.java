package br.com.mind5.business.employeePositionSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public class DaoEmposarchSelect implements DaoStmtExecV2<EmposarchInfo> {
	private DaoStmtExecV2<EmposarchInfo> helper;
	
	
	public DaoEmposarchSelect(List<DaoStmtExecOption<EmposarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmposarchSelectSingle.class, EmposarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmposarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
