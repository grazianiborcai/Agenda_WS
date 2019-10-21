package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CountrySelect implements DaoStmtExec<CountryInfo> {
	private DaoStmtExec<CountryInfo> helper;
	
	
	public CountrySelect(List<DaoStmtExecOption<CountryInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CountrySelectSingle.class, CountryInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountryInfo> getResultset() {
		return helper.getResultset();
	}
}
