package br.com.mind5.file.fileImage.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.file.fileImage.info.FimgInfo;

public final class DaoFimgSelect implements DaoStmtExecV2<FimgInfo> {
	private DaoStmtExecV2<FimgInfo> helper;
	
	
	public DaoFimgSelect(List<DaoStmtExecOption<FimgInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFimgSelectSingle.class, FimgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimgInfo> getResultset() {
		return helper.getResultset();
	}
	

	
	@Override public void close() {
		helper.close();		
	}
}
