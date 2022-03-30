package br.com.mind5.business.phone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class PhoneDaoDelete implements DaoStmtExec<PhoneInfo> {
	private DaoStmtExec<PhoneInfo> helper;
	
	
	public PhoneDaoDelete(List<DaoStmtExecOption<PhoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhoneDaoDeleteSingle.class, PhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhoneInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
