package br.com.gda.business.materialSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatSnapInsertText implements DaoStmtExec<MatSnapInfo> {
	private DaoStmtExec<MatSnapInfo> helper;
	
	
	public MatSnapInsertText(List<DaoStmtExecOption<MatSnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatSnapInsertTextSingle.class, MatSnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatSnapInfo> getResultset() {
		return helper.getResultset();
	}
}
