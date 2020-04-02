package br.com.mind5.file.fileImageSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;

public final class FimarchSelect implements DaoStmtExec_<FimarchInfo> {
	private DaoStmtExec_<FimarchInfo> helper;
	
	
	public FimarchSelect(List<DaoStmtExecOption<FimarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, FimarchSelectSingle.class, FimarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimarchInfo> getResultset() {
		return helper.getResultset();
	}
}
