package br.com.mind5.business.materialStoreSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatorarchSelect implements DaoStmtExec_<MatorarchInfo> {
	private DaoStmtExec_<MatorarchInfo> helper;
	
	
	public MatorarchSelect(List<DaoStmtExecOption<MatorarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatorarchSelectSingle.class, MatorarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatorarchInfo> getResultset() {
		return helper.getResultset();
	}
}
