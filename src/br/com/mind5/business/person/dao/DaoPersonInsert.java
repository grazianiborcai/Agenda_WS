package br.com.mind5.business.person.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoPersonInsert implements DaoStmtExecV2<PersonInfo> {
	private DaoStmtExecV2<PersonInfo> helper;
	
	
	public DaoPersonInsert(List<DaoStmtExecOption<PersonInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPersonInsertSingle.class, PersonInfo.class);
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
