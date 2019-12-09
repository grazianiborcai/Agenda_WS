package br.com.mind5.business.materialStoreSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatorarchSelect implements DaoStmtExec<MatorarchInfo> {
	private DaoStmtExec<MatorarchInfo> helper;
	
	
	public MatorarchSelect(List<DaoStmtExecOption<MatorarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatorarchSelectSingle.class, MatorarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatorarchInfo> getResultset() {
		return helper.getResultset();
	}
}
