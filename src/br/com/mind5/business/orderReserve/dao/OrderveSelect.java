package br.com.mind5.business.orderReserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class OrderveSelect implements DaoStmtExec<OrderveInfo> {
	private DaoStmtExec<OrderveInfo> helper;
	
	
	public OrderveSelect(List<DaoStmtExecOption<OrderveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrderveSelectSingle.class, OrderveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderveInfo> getResultset() {
		return helper.getResultset();
	}
}
