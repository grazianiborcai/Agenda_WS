package br.com.mind5.business.personBioSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPerbionapSelect implements DaoStmtExec<PerbionapInfo> {
	private DaoStmtExec<PerbionapInfo> helper;
	
	
	public DaoPerbionapSelect(List<DaoStmtExecOption<PerbionapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPerbionapSelectSingle.class, PerbionapInfo.class);
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
