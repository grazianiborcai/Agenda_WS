package br.com.mind5.business.employeePosition.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmposDaoDelete implements DaoStmtExec<EmposInfo> {
	private DaoStmtExec<EmposInfo> helper;
	
	
	public EmposDaoDelete(List<DaoStmtExecOption<EmposInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmposDaoDeleteSingle.class, EmposInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmposInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
