package br.com.mind5.security.userPasswordSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.dao.DaoUpswdarchSelect;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

final class VisiUpswdarchDaoSelect extends ActionVisitorTemplateStmt<UpswdarchInfo> {

	public VisiUpswdarchDaoSelect(DeciTreeOption<UpswdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UpswdarchInfo> buildStmtExecHook(List<DaoStmtExecOption<UpswdarchInfo>> stmtOptions) {
		return new DaoUpswdarchSelect(stmtOptions);
	}
}
