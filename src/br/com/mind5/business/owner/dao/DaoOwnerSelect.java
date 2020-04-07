package br.com.mind5.business.owner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOwnerSelect implements DaoStmtExecV2<OwnerInfo> {
	private DaoStmtExecV2<OwnerInfo> helper;
	
	
	public DaoOwnerSelect(List<DaoStmtExecOption<OwnerInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOwnerSelectSingle.class, OwnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnerInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
