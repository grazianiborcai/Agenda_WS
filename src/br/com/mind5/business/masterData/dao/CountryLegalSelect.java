package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CountryLegalSelect implements DaoStmtExec_<CountryLegalInfo> {
	private DaoStmtExec_<CountryLegalInfo> helper;
	
	
	public CountryLegalSelect(List<DaoStmtExecOption<CountryLegalInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CountryLegalSelectSingle.class, CountryLegalInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountryLegalInfo> getResultset() {
		return helper.getResultset();
	}
}
