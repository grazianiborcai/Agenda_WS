package br.com.mind5.business.orderReserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoOrderveSelect implements DaoStmtExec<OrderveInfo> {
	private DaoStmtExec<OrderveInfo> helper;
	
	
	public DaoOrderveSelect(List<DaoStmtExecOption<OrderveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOrderveSelectSingle.class, OrderveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrderveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
