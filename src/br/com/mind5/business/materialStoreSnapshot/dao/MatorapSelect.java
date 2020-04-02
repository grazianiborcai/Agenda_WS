package br.com.mind5.business.materialStoreSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatorapSelect implements DaoStmtExec_<MatorapInfo> {
	private DaoStmtExec_<MatorapInfo> helper;
	
	
	public MatorapSelect(List<DaoStmtExecOption<MatorapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatorapSelectSingle.class, MatorapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatorapInfo> getResultset() {
		return helper.getResultset();
	}
}
