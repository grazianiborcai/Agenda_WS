package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class AreaPhoneSelect implements DaoStmtExec_<AreaPhoneInfo> {
	private DaoStmtExec_<AreaPhoneInfo> helper;
	
	
	public AreaPhoneSelect(List<DaoStmtExecOption<AreaPhoneInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, AreaPhoneSelectSingle.class, AreaPhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AreaPhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
