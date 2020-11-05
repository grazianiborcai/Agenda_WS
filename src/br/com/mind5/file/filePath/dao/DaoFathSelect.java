package br.com.mind5.file.filePath.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.file.filePath.info.FathInfo;

public final class DaoFathSelect implements DaoStmtExecV2<FathInfo> {
	private DaoStmtExecV2<FathInfo> helper;
	
	
	public DaoFathSelect(List<DaoStmtExecOption<FathInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFathSelectSingle.class, FathInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FathInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
