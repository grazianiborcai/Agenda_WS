package br.com.mind5.business.order.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class OrderDaoUpdate implements DaoStmtExec<OrderInfo> {
	private DaoStmtExec<OrderInfo> helper;
	
	
	public OrderDaoUpdate(List<DaoStmtExecOption<OrderInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrderDaoUpdateSingle.class, OrderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
