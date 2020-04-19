package br.com.mind5.message.sysMessage.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

public final class DaoSymsgSelect implements DaoStmtExecV2<SymsgInfo> {
	private DaoStmtExecV2<SymsgInfo> helper;
	
	
	public DaoSymsgSelect(List<DaoStmtExecOption<SymsgInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSymsgSelectSingle.class, SymsgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SymsgInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
