package br.com.mind5.masterData.movimentType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;

public final class MamovypeDaoSelect implements DaoStmtExec<MamovypeInfo> {
	private DaoStmtExec<MamovypeInfo> helper;
	
	
	public MamovypeDaoSelect(List<DaoStmtExecOption<MamovypeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MamovypeDaoSelectSingle.class, MamovypeInfo.class);
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
