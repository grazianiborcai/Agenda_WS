package br.com.mind5.business.storeLeaveDateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStolarchSelect implements DaoStmtExecV2<StolarchInfo> {
	private DaoStmtExecV2<StolarchInfo> helper;
	
	
	public DaoStolarchSelect(List<DaoStmtExecOption<StolarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStolarchSelectSingle.class, StolarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StolarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
