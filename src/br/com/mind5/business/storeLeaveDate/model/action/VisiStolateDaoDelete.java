package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.dao.DaoStolateDelete;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolateDaoDelete extends ActionVisitorTemplateStmtV2<StolateInfo> {

	public VisiStolateDaoDelete(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StolateInfo> buildStmtExecHook(List<DaoStmtExecOption<StolateInfo>> stmtOptions) {
		return new DaoStolateDelete(stmtOptions);
	}
}
