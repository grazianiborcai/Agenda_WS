package br.com.mind5.business.materialSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatsnapSelect implements DaoStmtExec_<MatsnapInfo> {
	private DaoStmtExec_<MatsnapInfo> helper;
	
	
	public MatsnapSelect(List<DaoStmtExecOption<MatsnapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatsnapSelectSingle.class, MatsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatsnapInfo> getResultset() {
		return helper.getResultset();
	}
}
