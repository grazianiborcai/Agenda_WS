package br.com.mind5.message.email.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.message.email.info.EmailInfo;

public final class EmailDaoSelect implements DaoStmtExec<EmailInfo> {
	private DaoStmtExec<EmailInfo> helper;
	
	
	public EmailDaoSelect(List<DaoStmtExecOption<EmailInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmailDaoSelectSingle.class, EmailInfo.class);
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
