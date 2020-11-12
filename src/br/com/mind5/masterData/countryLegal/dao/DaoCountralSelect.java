package br.com.mind5.masterData.countryLegal.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countryLegal.info.CountralInfo;

public final class DaoCountralSelect implements DaoStmtExecV2<CountralInfo> {
	private DaoStmtExecV2<CountralInfo> helper;
	
	
	public DaoCountralSelect(List<DaoStmtExecOption<CountralInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCountralSelectSingle.class, CountralInfo.class);
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
