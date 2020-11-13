package br.com.mind5.business.orderList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoOrdistSelect implements DaoStmtExec<OrdistInfo> {
	private DaoStmtExec<OrdistInfo> helper;
	
	
	public DaoOrdistSelect(List<DaoStmtExecOption<OrdistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOrdistSelectSingle.class, OrdistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdistInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
