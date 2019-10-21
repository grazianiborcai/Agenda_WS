package br.com.mind5.business.form.formPhone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class FormPhoneSelect implements DaoStmtExec<FormPhoneInfo> {
	private DaoStmtExec<FormPhoneInfo> helper;
	
	
	public FormPhoneSelect(List<DaoStmtExecOption<FormPhoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FormPhoneSelectSingle.class, FormPhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FormPhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
