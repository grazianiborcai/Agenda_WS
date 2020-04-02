package br.com.mind5.business.orderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrderemInsert implements DaoStmtExec_<OrderemInfo> {
	private DaoStmtExec_<OrderemInfo> helper;
	
	
	public OrderemInsert(List<DaoStmtExecOption<OrderemInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrderemInsertSingle.class, OrderemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderemInfo> getResultset() {
		return helper.getResultset();
	}
}
