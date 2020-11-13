package br.com.mind5.masterData.country.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.country.info.CountryInfo;

public final class DaoCountrySelect implements DaoStmtExec<CountryInfo> {
	private DaoStmtExec<CountryInfo> helper;
	
	
	public DaoCountrySelect(List<DaoStmtExecOption<CountryInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCountrySelectSingle.class, CountryInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountryInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
