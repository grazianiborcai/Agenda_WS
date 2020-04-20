package br.com.mind5.file.fileImageList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.file.fileImageList.info.FimistInfo;

public final class DaoFimistSelect implements DaoStmtExecV2<FimistInfo> {
	private DaoStmtExecV2<FimistInfo> helper;
	
	
	public DaoFimistSelect(List<DaoStmtExecOption<FimistInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFimistSelectSingle.class, FimistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimistInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
