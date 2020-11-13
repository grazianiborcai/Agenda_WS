package br.com.mind5.masterData.authorizationGroup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.authorizationGroup.dao.DaoAuthgroupSelect;
import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAuthgroupDaoSelect extends ActionVisitorTemplateStmt<AuthgroupInfo> {

	public VisiAuthgroupDaoSelect(DeciTreeOption<AuthgroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AuthgroupInfo> buildStmtExecHook(List<DaoStmtExecOption<AuthgroupInfo>> stmtOptions) {
		return new DaoAuthgroupSelect(stmtOptions);
	}
}
