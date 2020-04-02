package br.com.mind5.file.fileImage.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.file.fileImage.info.FimgInfo;

public final class FimgDelete implements DaoStmtExec_<FimgInfo> {
	private DaoStmtExec_<FimgInfo> helper;
	
	
	public FimgDelete(List<DaoStmtExecOption<FimgInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, FimgDeleteSingle.class, FimgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimgInfo> getResultset() {
		return helper.getResultset();
	}
}
