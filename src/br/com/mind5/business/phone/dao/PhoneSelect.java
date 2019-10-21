package br.com.mind5.business.phone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class PhoneSelect implements DaoStmtExec<PhoneInfo> {
	private DaoStmtExec<PhoneInfo> helper;
	
	
	public PhoneSelect(List<DaoStmtExecOption<PhoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhoneSelectSingle.class, PhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
