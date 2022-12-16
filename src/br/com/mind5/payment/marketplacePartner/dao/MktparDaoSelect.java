package br.com.mind5.payment.marketplacePartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class MktparDaoSelect implements DaoStmtExec<MktparInfo> {
	private DaoStmtExec<MktparInfo> helper;
	
	
	public MktparDaoSelect(List<DaoStmtExecOption<MktparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MktparDaoSelectSingle.class, MktparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MktparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
