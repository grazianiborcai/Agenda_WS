package br.com.mind5.business.addressSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class AddarchSelect implements DaoStmtExec_<AddarchInfo> {
	private DaoStmtExec_<AddarchInfo> helper;
	
	
	public AddarchSelect(List<DaoStmtExecOption<AddarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, AddarchSelectSingle.class, AddarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddarchInfo> getResultset() {
		return helper.getResultset();
	}
}
