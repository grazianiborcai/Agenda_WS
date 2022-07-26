package br.com.mind5.form.formPhone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.form.formPhone.info.FormoneInfo;

public final class FormoneDaoSelect implements DaoStmtExec<FormoneInfo> {
	private DaoStmtExec<FormoneInfo> helper;
	
	
	public FormoneDaoSelect(List<DaoStmtExecOption<FormoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FormoneDaoSelectSingle.class, FormoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FormoneInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
