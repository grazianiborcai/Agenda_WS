package br.com.mind5.masterData.movimentType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;

public final class DaoMamovypeSelect implements DaoStmtExecV2<MamovypeInfo> {
	private DaoStmtExecV2<MamovypeInfo> helper;
	
	
	public DaoMamovypeSelect(List<DaoStmtExecOption<MamovypeInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMamovypeSelectSingle.class, MamovypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MamovypeInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();
	}
}
