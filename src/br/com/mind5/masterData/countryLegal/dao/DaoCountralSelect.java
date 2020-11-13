package br.com.mind5.masterData.countryLegal.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryLegal.info.CountralInfo;

public final class DaoCountralSelect implements DaoStmtExec<CountralInfo> {
	private DaoStmtExec<CountralInfo> helper;
	
	
	public DaoCountralSelect(List<DaoStmtExecOption<CountralInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCountralSelectSingle.class, CountralInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountralInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
