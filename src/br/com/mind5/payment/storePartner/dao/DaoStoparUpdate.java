package br.com.mind5.payment.storePartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class DaoStoparUpdate implements DaoStmtExec<StoparInfo> {
	private DaoStmtExec<StoparInfo> helper;
	
	
	public DaoStoparUpdate(List<DaoStmtExecOption<StoparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStoparUpdateSingle.class, StoparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
