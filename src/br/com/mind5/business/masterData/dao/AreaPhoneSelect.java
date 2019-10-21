package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class AreaPhoneSelect implements DaoStmtExec<AreaPhoneInfo> {
	private DaoStmtExec<AreaPhoneInfo> helper;
	
	
	public AreaPhoneSelect(List<DaoStmtExecOption<AreaPhoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AreaPhoneSelectSingle.class, AreaPhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AreaPhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
