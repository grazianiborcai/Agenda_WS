package br.com.mind5.business.orderReserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrderveSelect implements DaoStmtExec_<OrderveInfo> {
	private DaoStmtExec_<OrderveInfo> helper;
	
	
	public OrderveSelect(List<DaoStmtExecOption<OrderveInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrderveSelectSingle.class, OrderveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderveInfo> getResultset() {
		return helper.getResultset();
	}
}
