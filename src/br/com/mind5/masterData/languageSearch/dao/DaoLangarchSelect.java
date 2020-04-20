package br.com.mind5.masterData.languageSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;

public final class DaoLangarchSelect implements DaoStmtExecV2<LangarchInfo> {
	private DaoStmtExecV2<LangarchInfo> helper;
	
	
	public DaoLangarchSelect(List<DaoStmtExecOption<LangarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoLangarchSelectSingle.class, LangarchInfo.class);
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
