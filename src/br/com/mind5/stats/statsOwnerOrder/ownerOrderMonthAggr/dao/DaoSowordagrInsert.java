package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;

public final class DaoSowordagrInsert implements DaoStmtExec<SowordagrInfo> {
	private DaoStmtExec<SowordagrInfo> helper;
	
	
	public DaoSowordagrInsert(List<DaoStmtExecOption<SowordagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSowordagrInsertSingle.class, SowordagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<SowordagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
