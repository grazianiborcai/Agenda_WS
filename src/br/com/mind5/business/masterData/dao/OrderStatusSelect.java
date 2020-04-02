package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrderStatusSelect implements DaoStmtExec_<OrderStatusInfo> {
	private DaoStmtExec_<OrderStatusInfo> helper;
	
	
	public OrderStatusSelect(List<DaoStmtExecOption<OrderStatusInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrderStatusSelectSingle.class, OrderStatusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderStatusInfo> getResultset() {
		return helper.getResultset();
	}
}
