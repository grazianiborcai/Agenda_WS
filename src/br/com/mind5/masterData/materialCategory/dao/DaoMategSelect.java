package br.com.mind5.masterData.materialCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialCategory.info.MategInfo;

public final class DaoMategSelect implements DaoStmtExecV2<MategInfo> {
	private DaoStmtExecV2<MategInfo> helper;
	
	
	public DaoMategSelect(List<DaoStmtExecOption<MategInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMategSelectSingle.class, MategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MategInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
