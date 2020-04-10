package br.com.mind5.business.form.formAddressSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoFormesarchSelect implements DaoStmtExecV2<FormesarchInfo> {
	private DaoStmtExecV2<FormesarchInfo> helper;
	
	
	public DaoFormesarchSelect(List<DaoStmtExecOption<FormesarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFormesarchSelectSingle.class, FormesarchInfo.class);
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
