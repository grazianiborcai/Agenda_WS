package br.com.mind5.message.email.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.message.email.info.EmailInfo;

public final class DaoEmailSelect implements DaoStmtExecV2<EmailInfo> {
	private DaoStmtExecV2<EmailInfo> helper;
	
	
	public DaoEmailSelect(List<DaoStmtExecOption<EmailInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmailSelectSingle.class, EmailInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmailInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
