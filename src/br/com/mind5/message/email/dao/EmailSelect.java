package br.com.mind5.message.email.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.message.email.info.EmailInfo;

public final class EmailSelect implements DaoStmtExec_<EmailInfo> {
	private DaoStmtExec_<EmailInfo> helper;
	
	
	public EmailSelect(List<DaoStmtExecOption<EmailInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmailSelectSingle.class, EmailInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmailInfo> getResultset() {
		return helper.getResultset();
	}
}
