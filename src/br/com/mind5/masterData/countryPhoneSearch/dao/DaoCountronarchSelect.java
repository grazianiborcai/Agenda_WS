package br.com.mind5.masterData.countryPhoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;

public final class DaoCountronarchSelect implements DaoStmtExecV2<CountronarchInfo> {
	private DaoStmtExecV2<CountronarchInfo> helper;
	
	
	public DaoCountronarchSelect(List<DaoStmtExecOption<CountronarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCountronarchSelectSingle.class, CountronarchInfo.class);
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
