package br.com.mind5.masterData.orderStatus.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;

public final class DaoOrderatusSelect implements DaoStmtExecV2<OrderatusInfo> {
	private DaoStmtExecV2<OrderatusInfo> helper;
	
	
	public DaoOrderatusSelect(List<DaoStmtExecOption<OrderatusInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrderatusSelectSingle.class, OrderatusInfo.class);
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
