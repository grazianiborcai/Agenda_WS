package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CountryLegalSelect implements DaoStmtExec<CountryLegalInfo> {
	private DaoStmtExec<CountryLegalInfo> helper;
	
	
	public CountryLegalSelect(List<DaoStmtExecOption<CountryLegalInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CountryLegalSelectSingle.class, CountryLegalInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountryLegalInfo> getResultset() {
		return helper.getResultset();
	}
}
