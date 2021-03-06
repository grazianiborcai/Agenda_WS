package br.com.mind5.config.sysOwnerSignup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.config.sysOwnerSignup.dao.DaoSysonupSelect;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysonupDaoSelect extends ActionVisitorTemplateStmt<SysonupInfo> {

	public VisiSysonupDaoSelect(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysonupInfo> buildStmtExecHook(List<DaoStmtExecOption<SysonupInfo>> stmtOptions) {
		return new DaoSysonupSelect(stmtOptions);
	}
}
