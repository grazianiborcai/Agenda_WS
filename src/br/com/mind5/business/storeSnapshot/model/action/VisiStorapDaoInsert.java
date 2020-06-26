package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeSnapshot.dao.DaoStorapInsert;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorapDaoInsert extends ActionVisitorTemplateStmtV2<StorapInfo> {

	public VisiStorapDaoInsert(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StorapInfo> buildStmtExecHook(List<DaoStmtExecOption<StorapInfo>> stmtOptions) {
		return new DaoStorapInsert(stmtOptions);
	}
}
