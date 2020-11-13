package br.com.mind5.masterData.materialCategorySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;

public final class DaoMategarchSelect implements DaoStmtExec<MategarchInfo> {
	private DaoStmtExec<MategarchInfo> helper;
	
	
	public DaoMategarchSelect(List<DaoStmtExecOption<MategarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMategarchSelectSingle.class, MategarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MategarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
