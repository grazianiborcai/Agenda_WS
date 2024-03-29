package br.com.mind5.masterData.fileDocType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.fileDocType.info.FidoceInfo;

public final class FidoceDaoSelect implements DaoStmtExec<FidoceInfo> {
	private DaoStmtExec<FidoceInfo> helper;
	
	
	public FidoceDaoSelect(List<DaoStmtExecOption<FidoceInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FidoceDaoSelectSingle.class, FidoceInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FidoceInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
