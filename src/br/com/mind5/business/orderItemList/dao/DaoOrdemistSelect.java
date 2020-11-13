package br.com.mind5.business.orderItemList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoOrdemistSelect implements DaoStmtExec<OrdemistInfo> {
	private DaoStmtExec<OrdemistInfo> helper;
	
	
	public DaoOrdemistSelect(List<DaoStmtExecOption<OrdemistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOrdemistSelectSingle.class, OrdemistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdemistInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
