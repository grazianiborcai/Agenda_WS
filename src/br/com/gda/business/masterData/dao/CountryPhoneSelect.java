package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CountryPhoneSelect implements DaoStmtExec<CountryPhoneInfo> {
	private DaoStmtExec<CountryPhoneInfo> helper;
	
	
	public CountryPhoneSelect(List<DaoStmtExecOption<CountryPhoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CountryPhoneSelectSingle.class, CountryPhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountryPhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
