package br.com.gda.message.email.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.message.email.info.EmailInfo;

public final class EmailSelect implements DaoStmtExec<EmailInfo> {
	private DaoStmtExec<EmailInfo> helper;
	
	
	public EmailSelect(List<DaoStmtExecOption<EmailInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmailSelectSingle.class, EmailInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmailInfo> getResultset() {
		return helper.getResultset();
	}
}
