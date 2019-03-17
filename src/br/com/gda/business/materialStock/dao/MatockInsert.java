package br.com.gda.business.materialStock.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatockInsert implements DaoStmtExec<MatockInfo> {
	private DaoStmtExec<MatockInfo> helper;
	
	
	public MatockInsert(List<DaoStmtExecOption<MatockInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatockInsertSingle.class, MatockInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatockInfo> getResultset() {
		return helper.getResultset();
	}
}
