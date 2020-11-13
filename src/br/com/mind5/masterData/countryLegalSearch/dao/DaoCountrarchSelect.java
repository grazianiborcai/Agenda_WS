package br.com.mind5.masterData.countryLegalSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;

public final class DaoCountrarchSelect implements DaoStmtExec<CountrarchInfo> {
	private DaoStmtExec<CountrarchInfo> helper;
	
	
	public DaoCountrarchSelect(List<DaoStmtExecOption<CountrarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCountrarchSelectSingle.class, CountrarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountrarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
