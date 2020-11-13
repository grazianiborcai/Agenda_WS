package br.com.mind5.masterData.prospectStatus.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;

public final class DaoProstusSelect implements DaoStmtExec<ProstusInfo> {
	private DaoStmtExec<ProstusInfo> helper;
	
	
	public DaoProstusSelect(List<DaoStmtExecOption<ProstusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoProstusSelectSingle.class, ProstusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ProstusInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
