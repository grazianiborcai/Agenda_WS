package br.com.mind5.config.sysStoreSignup.model.action;

import java.util.List;

import br.com.mind5.config.sysStoreSignup.dao.SysotupDaoSelect;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysotupVisiDaoSelect extends ActionVisitorTemplateStmt<SysotupInfo> {

	public SysotupVisiDaoSelect(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysotupInfo> buildStmtExecHook(List<DaoStmtExecOption<SysotupInfo>> stmtOptions) {
		return new SysotupDaoSelect(stmtOptions);
	}
}
