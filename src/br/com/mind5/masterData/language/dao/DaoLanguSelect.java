package br.com.mind5.masterData.language.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.language.info.LanguInfo;

public final class DaoLanguSelect implements DaoStmtExecV2<LanguInfo> {
	private DaoStmtExecV2<LanguInfo> helper;
	
	
	public DaoLanguSelect(List<DaoStmtExecOption<LanguInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoLanguSelectSingle.class, LanguInfo.class);
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
