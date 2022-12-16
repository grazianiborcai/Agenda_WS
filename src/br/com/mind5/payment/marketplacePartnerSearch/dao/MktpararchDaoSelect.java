package br.com.mind5.payment.marketplacePartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.payment.marketplacePartnerSearch.info.MktpararchInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class MktpararchDaoSelect implements DaoStmtExec<MktpararchInfo> {
	private DaoStmtExec<MktpararchInfo> helper;
	
	
	public MktpararchDaoSelect(List<DaoStmtExecOption<MktpararchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MktpararchDaoSelectSingle.class, MktpararchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MktpararchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
