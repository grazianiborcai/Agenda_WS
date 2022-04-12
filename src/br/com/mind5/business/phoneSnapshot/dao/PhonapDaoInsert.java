package br.com.mind5.business.phoneSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class PhonapDaoInsert implements DaoStmtExec<PhonapInfo> {
	private DaoStmtExec<PhonapInfo> helper;
	
	
	public PhonapDaoInsert(List<DaoStmtExecOption<PhonapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhonapDaoInsertSingle.class, PhonapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
