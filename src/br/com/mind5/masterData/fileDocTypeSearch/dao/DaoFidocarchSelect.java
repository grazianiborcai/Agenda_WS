package br.com.mind5.masterData.fileDocTypeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;

public final class DaoFidocarchSelect implements DaoStmtExecV2<FidocarchInfo> {
	private DaoStmtExecV2<FidocarchInfo> helper;
	
	
	public DaoFidocarchSelect(List<DaoStmtExecOption<FidocarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFidocarchSelectSingle.class, FidocarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FidocarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
