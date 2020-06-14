package br.com.mind5.masterData.prospectStatusSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;

public final class DaoProstarchSelect implements DaoStmtExecV2<ProstarchInfo> {
	private DaoStmtExecV2<ProstarchInfo> helper;
	
	
	public DaoProstarchSelect(List<DaoStmtExecOption<ProstarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoProstarchSelectSingle.class, ProstarchInfo.class);
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
