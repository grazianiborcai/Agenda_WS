package br.com.gda.business.person.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PersonUpdate implements DaoStmtExec<PersonInfo> {
	private DaoStmtExec<PersonInfo> helper;
	
	
	public PersonUpdate(List<DaoStmtExecOption<PersonInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PersonUpdateSingle.class, PersonInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersonInfo> getResultset() {
		return helper.getResultset();
	}
}
