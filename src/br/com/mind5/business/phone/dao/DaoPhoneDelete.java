package br.com.mind5.business.phone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoPhoneDelete implements DaoStmtExecV2<PhoneInfo> {
	private DaoStmtExecV2<PhoneInfo> helper;
	
	
	public DaoPhoneDelete(List<DaoStmtExecOption<PhoneInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPhoneDeleteSingle.class, PhoneInfo.class);
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
