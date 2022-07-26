package br.com.mind5.config.sysOwnerConfig.model.action;

import java.util.List;

import br.com.mind5.config.sysOwnerConfig.dao.SysonfigDaoInsert;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysonfigVisiDaoInsert extends ActionVisitorTemplateStmt<SysonfigInfo> {

	public SysonfigVisiDaoInsert(DeciTreeOption<SysonfigInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysonfigInfo> buildStmtExecHook(List<DaoStmtExecOption<SysonfigInfo>> stmtOptions) {
		return new SysonfigDaoInsert(stmtOptions);
	}
}
