package br.com.mind5.business.materialTextSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatextsnapSelect implements DaoStmtExecV2<MatextsnapInfo> {
	private DaoStmtExecV2<MatextsnapInfo> helper;
	
	
	public DaoMatextsnapSelect(List<DaoStmtExecOption<MatextsnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatextsnapSelectSingle.class, MatextsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextsnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
