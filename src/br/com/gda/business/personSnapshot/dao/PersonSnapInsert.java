package br.com.gda.business.personSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PersonSnapInsert implements DaoStmtExec<PersonSnapInfo> {
	private DaoStmtExec<PersonSnapInfo> helper;
	
	
	public PersonSnapInsert(List<DaoStmtExecOption<PersonSnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PersonSnapInsertSingle.class, PersonSnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersonSnapInfo> getResultset() {
		return helper.getResultset();
	}
}
