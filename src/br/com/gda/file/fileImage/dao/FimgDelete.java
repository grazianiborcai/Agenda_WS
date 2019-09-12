package br.com.gda.file.fileImage.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.file.fileImage.info.FimgInfo;

public final class FimgDelete implements DaoStmtExec<FimgInfo> {
	private DaoStmtExec<FimgInfo> helper;
	
	
	public FimgDelete(List<DaoStmtExecOption<FimgInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FimgDeleteSingle.class, FimgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimgInfo> getResultset() {
		return helper.getResultset();
	}
}
