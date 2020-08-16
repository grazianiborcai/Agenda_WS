package br.com.mind5.business.materialStoreSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatorapInsert implements DaoStmtExecV2<MatorapInfo> {
	private DaoStmtExecV2<MatorapInfo> helper;
	
	
	public DaoMatorapInsert(List<DaoStmtExecOption<MatorapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatorapInsertSingle.class, MatorapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatorapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
