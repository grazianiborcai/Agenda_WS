package br.com.mind5.business.orderItemList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOrdemistSelect implements DaoStmtExecV2<OrdemistInfo> {
	private DaoStmtExecV2<OrdemistInfo> helper;
	
	
	public DaoOrdemistSelect(List<DaoStmtExecOption<OrdemistInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrdemistSelectSingle.class, OrdemistInfo.class);
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
