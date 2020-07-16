package br.com.mind5.business.materialSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatsnapInsert implements DaoStmtExecV2<MatsnapInfo> {
	private DaoStmtExecV2<MatsnapInfo> helper;
	
	
	public DaoMatsnapInsert(List<DaoStmtExecOption<MatsnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatsnapInsertSingle.class, MatsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatsnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
