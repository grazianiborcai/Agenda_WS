package br.com.mind5.file.filePath.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.file.filePath.info.FathInfo;

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
