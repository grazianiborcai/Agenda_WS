package br.com.mind5.business.scheduleReserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchederveSelect implements DaoStmtExecV2<SchederveInfo> {
	private DaoStmtExecV2<SchederveInfo> helper;
	
	
	public DaoSchederveSelect(List<DaoStmtExecOption<SchederveInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchederveSelectSingle.class, SchederveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchederveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
