package br.com.mind5.payment.ownerPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class DaoOwnparSelect implements DaoStmtExecV2<OwnparInfo> {
	private DaoStmtExecV2<OwnparInfo> helper;
	
	
	public DaoOwnparSelect(List<DaoStmtExecOption<OwnparInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOwnparSelectSingle.class, OwnparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
