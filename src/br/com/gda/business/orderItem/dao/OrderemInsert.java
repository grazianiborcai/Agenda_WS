package br.com.gda.business.orderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class OrderemInsert implements DaoStmtExec<OrderemInfo> {
	private DaoStmtExec<OrderemInfo> helper;
	
	
	public OrderemInsert(List<DaoStmtExecOption<OrderemInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrderemInsertSingle.class, OrderemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderemInfo> getResultset() {
		return helper.getResultset();
	}
}
