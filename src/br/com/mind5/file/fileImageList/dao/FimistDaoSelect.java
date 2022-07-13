package br.com.mind5.file.fileImageList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.fileImageList.info.FimistInfo;

public final class FimistDaoSelect implements DaoStmtExec<FimistInfo> {
	private DaoStmtExec<FimistInfo> helper;
	
	
	public FimistDaoSelect(List<DaoStmtExecOption<FimistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FimistDaoSelectSingle.class, FimistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimistInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
