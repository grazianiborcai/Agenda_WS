package br.com.mind5.config.sysOwnerSignup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.config.sysOwnerSignup.dao.DaoSysonupSelect;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysonupDaoSelect extends ActionVisitorTemplateStmtV2<SysonupInfo> {

	public VisiSysonupDaoSelect(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SysonupInfo> buildStmtExecHook(List<DaoStmtExecOption<SysonupInfo>> stmtOptions) {
		return new DaoSysonupSelect(stmtOptions);
	}
}
