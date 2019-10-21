package br.com.mind5.business.orderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
