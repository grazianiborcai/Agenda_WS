package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.dao.StolateDaoUpdate;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateVisiDaoUpdate extends ActionVisitorTemplateStmt<StolateInfo> {

	public StolateVisiDaoUpdate(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StolateInfo> buildStmtExecHook(List<DaoStmtExecOption<StolateInfo>> stmtOptions) {
		return new StolateDaoUpdate(stmtOptions);
	}
}
