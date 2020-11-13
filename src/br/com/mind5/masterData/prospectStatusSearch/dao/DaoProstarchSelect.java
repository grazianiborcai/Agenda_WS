package br.com.mind5.masterData.prospectStatusSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;

public final class DaoProstarchSelect implements DaoStmtExec<ProstarchInfo> {
	private DaoStmtExec<ProstarchInfo> helper;
	
	
	public DaoProstarchSelect(List<DaoStmtExecOption<ProstarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoProstarchSelectSingle.class, ProstarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ProstarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
