package br.com.mind5.masterData.businessArea.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

public final class DaoBusareaSelect implements DaoStmtExec<BusareaInfo> {
	private DaoStmtExec<BusareaInfo> helper;
	
	
	public DaoBusareaSelect(List<DaoStmtExecOption<BusareaInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoBusareaSelectSingle.class, BusareaInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BusareaInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
