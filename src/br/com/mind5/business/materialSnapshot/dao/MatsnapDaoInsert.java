package br.com.mind5.business.materialSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class MatsnapDaoInsert implements DaoStmtExec<MatsnapInfo> {
	private DaoStmtExec<MatsnapInfo> helper;
	
	
	public MatsnapDaoInsert(List<DaoStmtExecOption<MatsnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatsnapDaoInsertSingle.class, MatsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatsnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
