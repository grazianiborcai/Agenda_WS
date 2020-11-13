package br.com.mind5.masterData.orderStatus.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;

public final class DaoOrderatusSelect implements DaoStmtExec<OrderatusInfo> {
	private DaoStmtExec<OrderatusInfo> helper;
	
	
	public DaoOrderatusSelect(List<DaoStmtExecOption<OrderatusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOrderatusSelectSingle.class, OrderatusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderatusInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
