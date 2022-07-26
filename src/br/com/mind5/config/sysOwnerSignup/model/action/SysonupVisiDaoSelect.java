package br.com.mind5.config.sysOwnerSignup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.config.sysOwnerSignup.dao.SysonupDaoSelect;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysonupVisiDaoSelect extends ActionVisitorTemplateStmt<SysonupInfo> {

	public SysonupVisiDaoSelect(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysonupInfo> buildStmtExecHook(List<DaoStmtExecOption<SysonupInfo>> stmtOptions) {
		return new SysonupDaoSelect(stmtOptions);
	}
}
