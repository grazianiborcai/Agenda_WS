package br.com.mind5.business.form.formPhone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class FormPhoneSelect implements DaoStmtExec_<FormPhoneInfo> {
	private DaoStmtExec_<FormPhoneInfo> helper;
	
	
	public FormPhoneSelect(List<DaoStmtExecOption<FormPhoneInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, FormPhoneSelectSingle.class, FormPhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FormPhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
