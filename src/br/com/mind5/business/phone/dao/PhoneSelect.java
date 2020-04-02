package br.com.mind5.business.phone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PhoneSelect implements DaoStmtExec_<PhoneInfo> {
	private DaoStmtExec_<PhoneInfo> helper;
	
	
	public PhoneSelect(List<DaoStmtExecOption<PhoneInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PhoneSelectSingle.class, PhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
