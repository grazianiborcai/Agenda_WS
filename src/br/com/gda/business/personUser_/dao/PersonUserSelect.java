package br.com.gda.business.personUser_.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PersonUserSelect implements DaoStmtExec<PersonUserInfo> {
	private DaoStmtExec<PersonUserInfo> helper;
	
	
	public PersonUserSelect(List<DaoStmtExecOption<PersonUserInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PersonUserSelectSingle.class, PersonUserInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersonUserInfo> getResultset() {
		return helper.getResultset();
	}
}
