package br.com.mind5.form.formAddressSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;

public final class DaoFormesarchSelect implements DaoStmtExec<FormesarchInfo> {
	private DaoStmtExec<FormesarchInfo> helper;
	
	
	public DaoFormesarchSelect(List<DaoStmtExecOption<FormesarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoFormesarchSelectSingle.class, FormesarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FormesarchInfo> getResultset() {
		return helper.getResultset();
	}



	@Override public void close() {
		helper.close();		
	}
}
