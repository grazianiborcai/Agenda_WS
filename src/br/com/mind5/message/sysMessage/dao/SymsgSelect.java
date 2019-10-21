package br.com.mind5.message.sysMessage.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

public final class SymsgSelect implements DaoStmtExec<SymsgInfo> {
	private DaoStmtExec<SymsgInfo> helper;
	
	
	public SymsgSelect(List<DaoStmtExecOption<SymsgInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SymsgSelectSingle.class, SymsgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SymsgInfo> getResultset() {
		return helper.getResultset();
	}
}
