package br.com.mind5.payment.payOrderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class DaoPayordemUpdate implements DaoStmtExecV2<PayordemInfo> {
	private DaoStmtExecV2<PayordemInfo> helper;
	
	
	public DaoPayordemUpdate(List<DaoStmtExecOption<PayordemInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPayordemUpdateSingle.class, PayordemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordemInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
