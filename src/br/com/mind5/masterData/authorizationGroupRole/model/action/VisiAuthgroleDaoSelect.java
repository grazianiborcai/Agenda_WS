package br.com.mind5.masterData.authorizationGroupRole.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.authorizationGroupRole.dao.DaoAuthgroleSelect;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAuthgroleDaoSelect extends ActionVisitorTemplateStmt<AuthgroleInfo> {

	public VisiAuthgroleDaoSelect(DeciTreeOption<AuthgroleInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AuthgroleInfo> buildStmtExecHook(List<DaoStmtExecOption<AuthgroleInfo>> stmtOptions) {
		return new DaoAuthgroleSelect(stmtOptions);
	}
}
