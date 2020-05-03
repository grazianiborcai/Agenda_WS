package br.com.mind5.business.orderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOrderemSelect implements DaoStmtExecV2<OrderemInfo> {
	private DaoStmtExecV2<OrderemInfo> helper;
	
	
	public DaoOrderemSelect(List<DaoStmtExecOption<OrderemInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrderemSelectSingle.class, OrderemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderemInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
