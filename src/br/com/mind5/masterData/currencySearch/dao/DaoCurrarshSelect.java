package br.com.mind5.masterData.currencySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;

public final class DaoCurrarshSelect implements DaoStmtExec<CurrarshInfo> {
	private DaoStmtExec<CurrarshInfo> helper;
	
	
	public DaoCurrarshSelect(List<DaoStmtExecOption<CurrarshInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCurrarshSelectSingle.class, CurrarshInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CurrarshInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
