package br.com.gda.business.phone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PhoneInsert implements DaoStmtExec<PhoneInfo> {
	private DaoStmtExec<PhoneInfo> helper;
	
	
	public PhoneInsert(List<DaoStmtExecOption<PhoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhoneInsertSingle.class, PhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
