package br.com.mind5.masterData.authorizationGroupRole.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.authorizationGroupRole.dao.DaoAuthgroleSelect;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAuthgroleDaoSelect extends ActionVisitorTemplateStmtV2<AuthgroleInfo> {

	public VisiAuthgroleDaoSelect(DeciTreeOption<AuthgroleInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<AuthgroleInfo> buildStmtExecHook(List<DaoStmtExecOption<AuthgroleInfo>> stmtOptions) {
		return new DaoAuthgroleSelect(stmtOptions);
	}
}
