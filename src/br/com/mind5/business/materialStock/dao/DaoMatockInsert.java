package br.com.mind5.business.materialStock.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatockInsert implements DaoStmtExecV2<MatockInfo> {
	private DaoStmtExecV2<MatockInfo> helper;
	
	
	public DaoMatockInsert(List<DaoStmtExecOption<MatockInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatockInsertSingle.class, MatockInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatockInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
