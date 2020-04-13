package br.com.mind5.form.formPhone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.form.formPhone.info.FormoneInfo;

public final class DaoFormoneSelect implements DaoStmtExecV2<FormoneInfo> {
	private DaoStmtExecV2<FormoneInfo> helper;
	
	
	public DaoFormoneSelect(List<DaoStmtExecOption<FormoneInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFormoneSelectSingle.class, FormoneInfo.class);
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
