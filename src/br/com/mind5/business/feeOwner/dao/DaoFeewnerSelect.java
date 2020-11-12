package br.com.mind5.business.feeOwner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoFeewnerSelect implements DaoStmtExecV2<FeewnerInfo> {
	private DaoStmtExecV2<FeewnerInfo> helper;
	
	
	public DaoFeewnerSelect(List<DaoStmtExecOption<FeewnerInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFeewnerSelectSingle.class, FeewnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeewnerInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
