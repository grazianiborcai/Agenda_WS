package br.com.mind5.config.payPartnerConfig.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class PayrconfDaoSelect implements DaoStmtExec<PayrconfInfo> {
	private DaoStmtExec<PayrconfInfo> helper;
	
	
	public PayrconfDaoSelect(List<DaoStmtExecOption<PayrconfInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayrconfDaoSelectSingle.class, PayrconfInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayrconfInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
