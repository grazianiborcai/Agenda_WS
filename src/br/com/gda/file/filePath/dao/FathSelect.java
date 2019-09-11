package br.com.gda.file.filePath.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.file.filePath.info.FathInfo;

public final class FathSelect implements DaoStmtExec<FathInfo> {
	private DaoStmtExec<FathInfo> helper;
	
	
	public FathSelect(List<DaoStmtExecOption<FathInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FathSelectSingle.class, FathInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FathInfo> getResultset() {
		return helper.getResultset();
	}
}
