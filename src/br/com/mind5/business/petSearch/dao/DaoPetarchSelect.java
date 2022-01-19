package br.com.mind5.business.petSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPetarchSelect implements DaoStmtExec<PetarchInfo> {
	private DaoStmtExec<PetarchInfo> helper;
	
	
	public DaoPetarchSelect(List<DaoStmtExecOption<PetarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPetarchSelectSingle.class, PetarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PetarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
