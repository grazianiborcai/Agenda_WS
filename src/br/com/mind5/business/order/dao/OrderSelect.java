package br.com.mind5.business.order.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrderSelect implements DaoStmtExec_<OrderInfo> {
	private DaoStmtExec_<OrderInfo> helper;
	
	
	public OrderSelect(List<DaoStmtExecOption<OrderInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrderSelectSingle.class, OrderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderInfo> getResultset() {
		return helper.getResultset();
	}
}
