package br.com.mind5.business.person.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPersonSelect implements DaoStmtExec<PersonInfo> {
	private DaoStmtExec<PersonInfo> helper;
	
	
	public DaoPersonSelect(List<DaoStmtExecOption<PersonInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPersonSelectSingle.class, PersonInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersonInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
