package br.com.mind5.form.formAddress.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.form.formAddress.info.FormessInfo;

public final class DaoFormessSelect implements DaoStmtExecV2<FormessInfo> {
	private DaoStmtExecV2<FormessInfo> helper;
	
	
	public DaoFormessSelect(List<DaoStmtExecOption<FormessInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFormessSelectSingle.class, FormessInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FormessInfo> getResultset() {
		return helper.getResultset();
	}



	@Override public void close() {
		helper.close();		
	}
}
