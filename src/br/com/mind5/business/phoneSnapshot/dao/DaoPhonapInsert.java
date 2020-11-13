package br.com.mind5.business.phoneSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoPhonapInsert implements DaoStmtExecV2<PhonapInfo> {
	private DaoStmtExecV2<PhonapInfo> helper;
	
	
	public DaoPhonapInsert(List<DaoStmtExecOption<PhonapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPhonapInsertSingle.class, PhonapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
