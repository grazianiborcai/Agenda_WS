package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeSnapshot.dao.DaoStorapSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorapDaoSelect extends ActionVisitorTemplateStmt<StorapInfo> {

	public VisiStorapDaoSelect(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorapInfo> buildStmtExecHook(List<DaoStmtExecOption<StorapInfo>> stmtOptions) {
		return new DaoStorapSelect(stmtOptions);
	}
}
