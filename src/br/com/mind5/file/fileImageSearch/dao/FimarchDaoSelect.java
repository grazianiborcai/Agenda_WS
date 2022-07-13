package br.com.mind5.file.fileImageSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;

public final class FimarchDaoSelect implements DaoStmtExec<FimarchInfo> {
	private DaoStmtExec<FimarchInfo> helper;
	
	
	public FimarchDaoSelect(List<DaoStmtExecOption<FimarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FimarchDaoSelectSingle.class, FimarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
