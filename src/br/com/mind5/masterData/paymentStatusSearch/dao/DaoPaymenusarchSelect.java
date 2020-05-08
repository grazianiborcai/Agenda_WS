package br.com.mind5.masterData.paymentStatusSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;

public final class DaoPaymenusarchSelect implements DaoStmtExecV2<PaymenusarchInfo> {
	private DaoStmtExecV2<PaymenusarchInfo> helper;
	
	
	public DaoPaymenusarchSelect(List<DaoStmtExecOption<PaymenusarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPaymenusarchSelectSingle.class, PaymenusarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PaymenusarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
