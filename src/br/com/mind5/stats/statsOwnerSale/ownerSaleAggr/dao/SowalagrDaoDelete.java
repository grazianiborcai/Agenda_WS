package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;

public final class SowalagrDaoDelete implements DaoStmtExec<SowalagrInfo> {
	private DaoStmtExec<SowalagrInfo> helper;
	
	
	public SowalagrDaoDelete(List<DaoStmtExecOption<SowalagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowalagrDaoDeleteSingle.class, SowalagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowalagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
