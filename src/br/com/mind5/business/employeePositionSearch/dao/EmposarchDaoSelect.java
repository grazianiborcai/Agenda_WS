package br.com.mind5.business.employeePositionSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public class EmposarchDaoSelect implements DaoStmtExec<EmposarchInfo> {
	private DaoStmtExec<EmposarchInfo> helper;
	
	
	public EmposarchDaoSelect(List<DaoStmtExecOption<EmposarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmposarchDaoSelectSingle.class, EmposarchInfo.class);
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
