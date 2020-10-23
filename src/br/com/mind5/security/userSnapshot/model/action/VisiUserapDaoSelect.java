package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.dao.DaoUserapSelect;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class VisiUserapDaoSelect extends ActionVisitorTemplateStmtV2<UserapInfo> {

	public VisiUserapDaoSelect(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<UserapInfo> buildStmtExecHook(List<DaoStmtExecOption<UserapInfo>> stmtOptions) {
		return new DaoUserapSelect(stmtOptions);
	}
}
