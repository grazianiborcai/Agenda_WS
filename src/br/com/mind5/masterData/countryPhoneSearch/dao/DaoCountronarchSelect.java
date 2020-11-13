package br.com.mind5.masterData.countryPhoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;

public final class DaoCountronarchSelect implements DaoStmtExec<CountronarchInfo> {
	private DaoStmtExec<CountronarchInfo> helper;
	
	
	public DaoCountronarchSelect(List<DaoStmtExecOption<CountronarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCountronarchSelectSingle.class, CountronarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountronarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
