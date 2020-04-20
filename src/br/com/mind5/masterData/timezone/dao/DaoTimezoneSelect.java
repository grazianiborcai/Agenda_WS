package br.com.mind5.masterData.timezone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

public final class DaoTimezoneSelect implements DaoStmtExecV2<TimezoneInfo> {
	private DaoStmtExecV2<TimezoneInfo> helper;
	
	
	public DaoTimezoneSelect(List<DaoStmtExecOption<TimezoneInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoTimezoneSelectSingle.class, TimezoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<TimezoneInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
