package br.com.mind5.business.orderItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class OrdemarchDaoSelect implements DaoStmtExec<OrdemarchInfo> {
	private DaoStmtExec<OrdemarchInfo> helper;
	
	
	public OrdemarchDaoSelect(List<DaoStmtExecOption<OrdemarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOrdemarchSelectSingle.class, OrdemarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdemarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
