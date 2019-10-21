package br.com.mind5.business.personUser_.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
