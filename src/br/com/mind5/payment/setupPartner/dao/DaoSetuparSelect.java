package br.com.mind5.payment.setupPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class DaoSetuparSelect implements DaoStmtExecV2<SetuparInfo> {
	private DaoStmtExecV2<SetuparInfo> helper;
	
	
	public DaoSetuparSelect(List<DaoStmtExecOption<SetuparInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSetuparSelectSingle.class, SetuparInfo.class);
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
