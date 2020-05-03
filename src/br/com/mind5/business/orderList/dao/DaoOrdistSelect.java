package br.com.mind5.business.orderList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOrdistSelect implements DaoStmtExecV2<OrdistInfo> {
	private DaoStmtExecV2<OrdistInfo> helper;
	
	
	public DaoOrdistSelect(List<DaoStmtExecOption<OrdistInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrdistSelectSingle.class, OrdistInfo.class);
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
