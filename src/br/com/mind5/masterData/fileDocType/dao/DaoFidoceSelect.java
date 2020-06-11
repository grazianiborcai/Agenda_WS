package br.com.mind5.masterData.fileDocType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.fileDocType.info.FidoceInfo;

public final class DaoFidoceSelect implements DaoStmtExecV2<FidoceInfo> {
	private DaoStmtExecV2<FidoceInfo> helper;
	
	
	public DaoFidoceSelect(List<DaoStmtExecOption<FidoceInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFidoceSelectSingle.class, FidoceInfo.class);
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
