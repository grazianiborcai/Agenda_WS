package br.com.mind5.masterData.areaPhoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;

public final class DaoAreanarchSelect implements DaoStmtExecV2<AreanarchInfo> {
	private DaoStmtExecV2<AreanarchInfo> helper;
	
	
	public DaoAreanarchSelect(List<DaoStmtExecOption<AreanarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoAreanarchSelectSingle.class, AreanarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AreanarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
