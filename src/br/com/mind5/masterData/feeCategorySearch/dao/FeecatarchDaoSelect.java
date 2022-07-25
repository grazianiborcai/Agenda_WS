package br.com.mind5.masterData.feeCategorySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;

public final class FeecatarchDaoSelect implements DaoStmtExec<FeecatarchInfo> {
	private DaoStmtExec<FeecatarchInfo> helper;
	
	
	public FeecatarchDaoSelect(List<DaoStmtExecOption<FeecatarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeecatarchDaoSelectSingle.class, FeecatarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeecatarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
