package br.com.mind5.business.personBioSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPerbiorchSelect implements DaoStmtExec<PerbiorchInfo> {
	private DaoStmtExec<PerbiorchInfo> helper;
	
	
	public DaoPerbiorchSelect(List<DaoStmtExecOption<PerbiorchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPerbiorchSelectSingle.class, PerbiorchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PerbiorchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
