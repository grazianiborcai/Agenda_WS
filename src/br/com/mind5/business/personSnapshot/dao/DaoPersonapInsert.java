package br.com.mind5.business.personSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPersonapInsert implements DaoStmtExec<PersonapInfo> {
	private DaoStmtExec<PersonapInfo> helper;
	
	
	public DaoPersonapInsert(List<DaoStmtExecOption<PersonapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPersonapInsertSingle.class, PersonapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersonapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
