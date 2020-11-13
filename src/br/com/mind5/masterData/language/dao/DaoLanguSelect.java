package br.com.mind5.masterData.language.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.language.info.LanguInfo;

public final class DaoLanguSelect implements DaoStmtExec<LanguInfo> {
	private DaoStmtExec<LanguInfo> helper;
	
	
	public DaoLanguSelect(List<DaoStmtExecOption<LanguInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoLanguSelectSingle.class, LanguInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<LanguInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
