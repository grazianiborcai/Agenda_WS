package br.com.mind5.business.personSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PersonapSelect implements DaoStmtExec_<PersonapInfo> {
	private DaoStmtExec_<PersonapInfo> helper;
	
	
	public PersonapSelect(List<DaoStmtExecOption<PersonapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PersonapSelectSingle.class, PersonapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersonapInfo> getResultset() {
		return helper.getResultset();
	}
}
