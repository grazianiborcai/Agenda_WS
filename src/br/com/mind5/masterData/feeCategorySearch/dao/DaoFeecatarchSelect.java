package br.com.mind5.masterData.feeCategorySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;

public final class DaoFeecatarchSelect implements DaoStmtExecV2<FeecatarchInfo> {
	private DaoStmtExecV2<FeecatarchInfo> helper;
	
	
	public DaoFeecatarchSelect(List<DaoStmtExecOption<FeecatarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFeecatarchSelectSingle.class, FeecatarchInfo.class);
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
