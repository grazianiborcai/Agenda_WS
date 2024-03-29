package br.com.mind5.business.personBio.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class PerbioDaoUpdate implements DaoStmtExec<PerbioInfo> {
	private DaoStmtExec<PerbioInfo> helper;
	
	
	public PerbioDaoUpdate(List<DaoStmtExecOption<PerbioInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PerbioDaoUpdateSingle.class, PerbioInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PerbioInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
