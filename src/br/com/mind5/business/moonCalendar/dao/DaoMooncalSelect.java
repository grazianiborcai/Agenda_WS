package br.com.mind5.business.moonCalendar.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMooncalSelect implements DaoStmtExecV2<MooncalInfo> {
	private DaoStmtExecV2<MooncalInfo> helper;
	
	
	public DaoMooncalSelect(List<DaoStmtExecOption<MooncalInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMooncalSelectSingle.class, MooncalInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MooncalInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
