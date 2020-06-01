package br.com.mind5.business.storeWorkTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStowotarchSelect implements DaoStmtExecV2<StowotarchInfo> {
	private DaoStmtExecV2<StowotarchInfo> helper;
	
	
	public DaoStowotarchSelect(List<DaoStmtExecOption<StowotarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStowotarchSelectSingle.class, StowotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StowotarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
