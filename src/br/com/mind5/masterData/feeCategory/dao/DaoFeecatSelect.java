package br.com.mind5.masterData.feeCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;

public final class DaoFeecatSelect implements DaoStmtExecV2<FeecatInfo> {
	private DaoStmtExecV2<FeecatInfo> helper;
	
	
	public DaoFeecatSelect(List<DaoStmtExecOption<FeecatInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFeecatSelectSingle.class, FeecatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeecatInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
