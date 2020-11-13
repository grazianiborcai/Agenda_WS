package br.com.mind5.business.ownerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.ownerSnapshot.dao.DaoOwnerapSelect;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerapDaoSelect extends ActionVisitorTemplateStmt<OwnerapInfo> {

	public VisiOwnerapDaoSelect(DeciTreeOption<OwnerapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OwnerapInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnerapInfo>> stmtOptions) {
		return new DaoOwnerapSelect(stmtOptions);
	}
}
