package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CountryPhoneSelect implements DaoStmtExec_<CountryPhoneInfo> {
	private DaoStmtExec_<CountryPhoneInfo> helper;
	
	
	public CountryPhoneSelect(List<DaoStmtExecOption<CountryPhoneInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CountryPhoneSelectSingle.class, CountryPhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountryPhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
