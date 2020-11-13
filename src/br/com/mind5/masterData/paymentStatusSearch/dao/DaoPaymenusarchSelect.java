package br.com.mind5.masterData.paymentStatusSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;

public final class DaoPaymenusarchSelect implements DaoStmtExec<PaymenusarchInfo> {
	private DaoStmtExec<PaymenusarchInfo> helper;
	
	
	public DaoPaymenusarchSelect(List<DaoStmtExecOption<PaymenusarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPaymenusarchSelectSingle.class, PaymenusarchInfo.class);
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
