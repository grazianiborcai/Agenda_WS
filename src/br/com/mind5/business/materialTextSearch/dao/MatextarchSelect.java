package br.com.mind5.business.materialTextSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatextarchSelect implements DaoStmtExec_<MatextarchInfo> {
	private DaoStmtExec_<MatextarchInfo> helper;
	
	
	public MatextarchSelect(List<DaoStmtExecOption<MatextarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatextarchSelectSingle.class, MatextarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextarchInfo> getResultset() {
		return helper.getResultset();
	}
}
