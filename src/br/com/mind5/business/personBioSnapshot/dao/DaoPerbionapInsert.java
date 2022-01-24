package br.com.mind5.business.personBioSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPerbionapInsert implements DaoStmtExec<PerbionapInfo> {
	private DaoStmtExec<PerbionapInfo> helper;
	
	
	public DaoPerbionapInsert(List<DaoStmtExecOption<PerbionapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPerbionapInsertSingle.class, PerbionapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PerbionapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
