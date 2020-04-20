package br.com.mind5.masterData.materialCategorySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;

public final class DaoMategarchSelect implements DaoStmtExecV2<MategarchInfo> {
	private DaoStmtExecV2<MategarchInfo> helper;
	
	
	public DaoMategarchSelect(List<DaoStmtExecOption<MategarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMategarchSelectSingle.class, MategarchInfo.class);
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
