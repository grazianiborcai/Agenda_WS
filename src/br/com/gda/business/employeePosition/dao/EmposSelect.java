package br.com.gda.business.employeePosition.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public class EmposSelect implements DaoStmtExec<EmposInfo> {
	private DaoStmtExec<EmposInfo> helper;
	
	
	public EmposSelect(List<DaoStmtExecOption<EmposInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmposSelectSingle.class, EmposInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmposInfo> getResultset() {
		return helper.getResultset();
	}
}
