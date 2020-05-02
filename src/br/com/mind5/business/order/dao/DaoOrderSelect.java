package br.com.mind5.business.order.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOrderSelect implements DaoStmtExecV2<OrderInfo> {
	private DaoStmtExecV2<OrderInfo> helper;
	
	
	public DaoOrderSelect(List<DaoStmtExecOption<OrderInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrderSelectSingle.class, OrderInfo.class);
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
