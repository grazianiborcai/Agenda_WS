package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class OrderStatusSelect implements DaoStmtExec<OrderStatusInfo> {
	private DaoStmtExec<OrderStatusInfo> helper;
	
	
	public OrderStatusSelect(List<DaoStmtExecOption<OrderStatusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrderStatusSelectSingle.class, OrderStatusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderStatusInfo> getResultset() {
		return helper.getResultset();
	}
}
