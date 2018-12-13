package br.com.gda.business.personCustomer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PersonCusSelect implements DaoStmtExec<PersonCusInfo> {
	private DaoStmtExec<PersonCusInfo> helper;
	
	
	public PersonCusSelect(List<DaoStmtExecOption<PersonCusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PersonCusSelectSingle.class, PersonCusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersonCusInfo> getResultset() {
		return helper.getResultset();
	}
}
