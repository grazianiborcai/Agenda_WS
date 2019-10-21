package br.com.mind5.file.fileImageList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.file.fileImageList.info.FimistInfo;

public final class FimistSelect implements DaoStmtExec<FimistInfo> {
	private DaoStmtExec<FimistInfo> helper;
	
	
	public FimistSelect(List<DaoStmtExecOption<FimistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FimistSelectSingle.class, FimistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimistInfo> getResultset() {
		return helper.getResultset();
	}
}
