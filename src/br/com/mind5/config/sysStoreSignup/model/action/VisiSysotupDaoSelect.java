package br.com.mind5.config.sysStoreSignup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.config.sysStoreSignup.dao.DaoSysotupSelect;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysotupDaoSelect extends ActionVisitorTemplateStmtV2<SysotupInfo> {

	public VisiSysotupDaoSelect(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SysotupInfo> buildStmtExecHook(List<DaoStmtExecOption<SysotupInfo>> stmtOptions) {
		return new DaoSysotupSelect(stmtOptions);
	}
}
