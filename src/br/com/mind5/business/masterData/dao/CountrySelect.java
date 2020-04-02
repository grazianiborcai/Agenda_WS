package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CountrySelect implements DaoStmtExec_<CountryInfo> {
	private DaoStmtExec_<CountryInfo> helper;
	
	
	public CountrySelect(List<DaoStmtExecOption<CountryInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CountrySelectSingle.class, CountryInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountryInfo> getResultset() {
		return helper.getResultset();
	}
}
