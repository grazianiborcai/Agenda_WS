package br.com.mind5.masterData.prospectStatus.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;

public final class DaoProstusSelect implements DaoStmtExecV2<ProstusInfo> {
	private DaoStmtExecV2<ProstusInfo> helper;
	
	
	public DaoProstusSelect(List<DaoStmtExecOption<ProstusInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoProstusSelectSingle.class, ProstusInfo.class);
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
