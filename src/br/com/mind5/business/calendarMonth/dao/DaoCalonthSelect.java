package br.com.mind5.business.calendarMonth.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoCalonthSelect implements DaoStmtExec<CalonthInfo> {
	private DaoStmtExec<CalonthInfo> helper;
	
	
	public DaoCalonthSelect(List<DaoStmtExecOption<CalonthInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCalonthSelectSingle.class, CalonthInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<CalonthInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();
	}
}
