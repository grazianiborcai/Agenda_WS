package br.com.mind5.masterData.gender.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.gender.info.GenderInfo;

public final class DaoGenderSelect implements DaoStmtExecV2<GenderInfo> {
	private DaoStmtExecV2<GenderInfo> helper;
	
	
	public DaoGenderSelect(List<DaoStmtExecOption<GenderInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoGenderSelectSingle.class, GenderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<GenderInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	@Override public void close() {
		helper.close();		
	}
}
