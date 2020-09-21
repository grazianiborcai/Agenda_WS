package br.com.mind5.business.storeTextSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStorextsnapInsert implements DaoStmtExecV2<StorextsnapInfo> {
	private DaoStmtExecV2<StorextsnapInfo> helper;
	
	
	public DaoStorextsnapInsert(List<DaoStmtExecOption<StorextsnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStorextsnapInsertSingle.class, StorextsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorextsnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
