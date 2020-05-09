package br.com.mind5.payment.payOrderItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class DaoPayormarchSelect implements DaoStmtExecV2<PayormarchInfo> {
	private DaoStmtExecV2<PayormarchInfo> helper;
	
	
	public DaoPayormarchSelect(List<DaoStmtExecOption<PayormarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPayormarchSelectSingle.class, PayormarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayormarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
