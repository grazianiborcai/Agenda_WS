package br.com.gda.payment.payOrderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class OrderemSelect implements DaoStmtExec<PayordemInfo> {
	private DaoStmtExec<PayordemInfo> helper;
	
	
	public OrderemSelect(List<DaoStmtExecOption<PayordemInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrderemSelectSingle.class, PayordemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordemInfo> getResultset() {
		return helper.getResultset();
	}
}
