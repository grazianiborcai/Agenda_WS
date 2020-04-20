package br.com.mind5.masterData.businessArea.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

public final class DaoBusareaSelect implements DaoStmtExecV2<BusareaInfo> {
	private DaoStmtExecV2<BusareaInfo> helper;
	
	
	public DaoBusareaSelect(List<DaoStmtExecOption<BusareaInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoBusareaSelectSingle.class, BusareaInfo.class);
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
