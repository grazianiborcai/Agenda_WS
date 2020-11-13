package br.com.mind5.payment.setupPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class DaoSetuparSelect implements DaoStmtExec<SetuparInfo> {
	private DaoStmtExec<SetuparInfo> helper;
	
	
	public DaoSetuparSelect(List<DaoStmtExecOption<SetuparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSetuparSelectSingle.class, SetuparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SetuparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
