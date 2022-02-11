package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;

public final class DaoSowaliveSelect implements DaoStmtExec<SowaliveInfo> {
	private DaoStmtExec<SowaliveInfo> helper;
	
	
	public DaoSowaliveSelect(List<DaoStmtExecOption<SowaliveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSowaliveSelectSingle.class, SowaliveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowaliveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
