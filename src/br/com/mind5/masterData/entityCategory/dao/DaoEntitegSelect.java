package br.com.mind5.masterData.entityCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;

public final class DaoEntitegSelect implements DaoStmtExec<EntitegInfo> {
	private DaoStmtExec<EntitegInfo> helper;
	
	
	public DaoEntitegSelect(List<DaoStmtExecOption<EntitegInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEntitegSelectSingle.class, EntitegInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EntitegInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
