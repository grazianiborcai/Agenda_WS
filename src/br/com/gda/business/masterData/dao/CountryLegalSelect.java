package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

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
