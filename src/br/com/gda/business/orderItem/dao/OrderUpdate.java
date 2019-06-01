package br.com.gda.business.orderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class OrderUpdate implements DaoStmtExec<OrderInfo> {
	private DaoStmtExec<OrderInfo> helper;
	
	
	public OrderUpdate(List<DaoStmtExecOption<OrderInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrderUpdateSingle.class, OrderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderInfo> getResultset() {
		return helper.getResultset();
	}
}
