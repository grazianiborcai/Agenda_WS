package br.com.mind5.masterData.petWeightSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.petWeightSearch.info.PeteightarchInfo;

public final class DaoPeteightarchSelect implements DaoStmtExec<PeteightarchInfo> {
	private DaoStmtExec<PeteightarchInfo> helper;
	
	
	public DaoPeteightarchSelect(List<DaoStmtExecOption<PeteightarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPeteightarchSelectSingle.class, PeteightarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PeteightarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
