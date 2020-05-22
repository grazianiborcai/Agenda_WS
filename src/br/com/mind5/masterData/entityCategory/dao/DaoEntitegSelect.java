package br.com.mind5.masterData.entityCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;

public final class DaoEntitegSelect implements DaoStmtExecV2<EntitegInfo> {
	private DaoStmtExecV2<EntitegInfo> helper;
	
	
	public DaoEntitegSelect(List<DaoStmtExecOption<EntitegInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEntitegSelectSingle.class, EntitegInfo.class);
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
