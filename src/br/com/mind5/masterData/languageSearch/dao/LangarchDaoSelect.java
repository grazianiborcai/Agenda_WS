package br.com.mind5.masterData.languageSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;

public final class LangarchDaoSelect implements DaoStmtExec<LangarchInfo> {
	private DaoStmtExec<LangarchInfo> helper;
	
	
	public LangarchDaoSelect(List<DaoStmtExecOption<LangarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, LangarchDaoSelectSingle.class, LangarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<LangarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
