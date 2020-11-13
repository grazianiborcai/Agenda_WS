package br.com.mind5.masterData.orderStatusSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;

public final class DaoOrderatarchSelect implements DaoStmtExec<OrderatarchInfo> {
	private DaoStmtExec<OrderatarchInfo> helper;
	
	
	public DaoOrderatarchSelect(List<DaoStmtExecOption<OrderatarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOrderatarchSelectSingle.class, OrderatarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderatarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
