package br.com.mind5.security.userSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.dao.DaoUserarchSelect;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class VisiUserarchDaoSelect extends ActionVisitorTemplateStmtV2<UserarchInfo> {

	public VisiUserarchDaoSelect(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<UserarchInfo> buildStmtExecHook(List<DaoStmtExecOption<UserarchInfo>> stmtOptions) {
		return new DaoUserarchSelect(stmtOptions);
	}
}
