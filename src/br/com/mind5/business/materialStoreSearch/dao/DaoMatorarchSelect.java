package br.com.mind5.business.materialStoreSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatorarchSelect implements DaoStmtExecV2<MatorarchInfo> {
	private DaoStmtExecV2<MatorarchInfo> helper;
	
	
	public DaoMatorarchSelect(List<DaoStmtExecOption<MatorarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatorarchSelectSingle.class, MatorarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatorarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
