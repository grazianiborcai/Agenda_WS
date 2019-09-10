package br.com.gda.file.fileUpload.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.file.fileUpload.info.FilupInfo;

public final class FilupUpdate implements DaoStmtExec<FilupInfo> {
	private DaoStmtExec<FilupInfo> helper;
	
	
	public FilupUpdate(List<DaoStmtExecOption<FilupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FilupUpdateSingle.class, FilupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FilupInfo> getResultset() {
		return helper.getResultset();
	}
}
