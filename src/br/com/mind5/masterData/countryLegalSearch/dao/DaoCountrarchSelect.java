package br.com.mind5.masterData.countryLegalSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;

public final class DaoCountrarchSelect implements DaoStmtExecV2<CountrarchInfo> {
	private DaoStmtExecV2<CountrarchInfo> helper;
	
	
	public DaoCountrarchSelect(List<DaoStmtExecOption<CountrarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCountrarchSelectSingle.class, CountrarchInfo.class);
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
