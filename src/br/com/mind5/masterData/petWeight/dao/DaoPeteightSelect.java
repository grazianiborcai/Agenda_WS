package br.com.mind5.masterData.petWeight.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;

public final class DaoPeteightSelect implements DaoStmtExec<PeteightInfo> {
	private DaoStmtExec<PeteightInfo> helper;
	
	
	public DaoPeteightSelect(List<DaoStmtExecOption<PeteightInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPeteightSelectSingle.class, PeteightInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PeteightInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
