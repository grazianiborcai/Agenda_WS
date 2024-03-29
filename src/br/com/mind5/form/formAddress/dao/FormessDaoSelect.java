package br.com.mind5.form.formAddress.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.form.formAddress.info.FormessInfo;

public final class FormessDaoSelect implements DaoStmtExec<FormessInfo> {
	private DaoStmtExec<FormessInfo> helper;
	
	
	public FormessDaoSelect(List<DaoStmtExecOption<FormessInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FormessDaoSelectSingle.class, FormessInfo.class);
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
