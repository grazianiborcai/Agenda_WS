package br.com.mind5.business.person.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PersonUpdate implements DaoStmtExec_<PersonInfo> {
	private DaoStmtExec_<PersonInfo> helper;
	
	
	public PersonUpdate(List<DaoStmtExecOption<PersonInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PersonUpdateSingle.class, PersonInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersonInfo> getResultset() {
		return helper.getResultset();
	}
}
