package br.com.mind5.masterData.country.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.country.info.CountryInfo;

public final class DaoCountrySelect implements DaoStmtExecV2<CountryInfo> {
	private DaoStmtExecV2<CountryInfo> helper;
	
	
	public DaoCountrySelect(List<DaoStmtExecOption<CountryInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCountrySelectSingle.class, CountryInfo.class);
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
