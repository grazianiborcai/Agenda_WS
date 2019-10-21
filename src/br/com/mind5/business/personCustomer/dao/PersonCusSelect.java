package br.com.mind5.business.personCustomer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
