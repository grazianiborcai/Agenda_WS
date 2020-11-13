package br.com.mind5.masterData.position.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.position.info.PositionInfo;

public final class DaoPositionSelect implements DaoStmtExec<PositionInfo> {
	private DaoStmtExec<PositionInfo> helper;
	
	
	public DaoPositionSelect(List<DaoStmtExecOption<PositionInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPositionSelectSingle.class, PositionInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PositionInfo> getResultset() {
		return helper.getResultset();
	}

	
	@Override public void close() {
		helper.close();		
	}
}
