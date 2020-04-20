package br.com.mind5.masterData.timezoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;

public final class DaoTimezonarchSelect implements DaoStmtExecV2<TimezonarchInfo> {
	private DaoStmtExecV2<TimezonarchInfo> helper;
	
	
	public DaoTimezonarchSelect(List<DaoStmtExecOption<TimezonarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoTimezonarchSelectSingle.class, TimezonarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<TimezonarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
