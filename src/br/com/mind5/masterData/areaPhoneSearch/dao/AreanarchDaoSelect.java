package br.com.mind5.masterData.areaPhoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;

public final class AreanarchDaoSelect implements DaoStmtExec<AreanarchInfo> {
	private DaoStmtExec<AreanarchInfo> helper;
	
	
	public AreanarchDaoSelect(List<DaoStmtExecOption<AreanarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AreanarchDaoSelectSingle.class, AreanarchInfo.class);
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
