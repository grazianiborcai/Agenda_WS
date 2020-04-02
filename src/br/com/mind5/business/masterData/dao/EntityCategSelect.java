package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EntityCategSelect implements DaoStmtExec_<EntityCategInfo> {
	private DaoStmtExec_<EntityCategInfo> helper;
	
	
	public EntityCategSelect(List<DaoStmtExecOption<EntityCategInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EntityCategSelectSingle.class, EntityCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EntityCategInfo> getResultset() {
		return helper.getResultset();
	}
}
