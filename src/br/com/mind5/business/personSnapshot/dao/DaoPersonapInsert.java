package br.com.mind5.business.personSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoPersonapInsert implements DaoStmtExecV2<PersonapInfo> {
	private DaoStmtExecV2<PersonapInfo> helper;
	
	
	public DaoPersonapInsert(List<DaoStmtExecOption<PersonapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPersonapInsertSingle.class, PersonapInfo.class);
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
