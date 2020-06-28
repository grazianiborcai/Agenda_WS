package br.com.mind5.business.company.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCompInsert implements DaoStmtExecV2<CompInfo> {
	private DaoStmtExecV2<CompInfo> helper;
	
	
	public DaoCompInsert(List<DaoStmtExecOption<CompInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCompInsertSingle.class, CompInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
