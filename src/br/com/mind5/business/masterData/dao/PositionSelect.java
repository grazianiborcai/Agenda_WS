package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PositionSelect implements DaoStmtExec_<PositionInfo> {
	private DaoStmtExec_<PositionInfo> helper;
	
	
	public PositionSelect(List<DaoStmtExecOption<PositionInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PositionSelectSingle.class, PositionInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PositionInfo> getResultset() {
		return helper.getResultset();
	}
}
