package br.com.mind5.payment.payOrderItemList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class DaoPayordemistSelect implements DaoStmtExecV2<PayordemistInfo> {
	private DaoStmtExecV2<PayordemistInfo> helper;
	
	
	public DaoPayordemistSelect(List<DaoStmtExecOption<PayordemistInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPayordemistSelectSingle.class, PayordemistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordemistInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
