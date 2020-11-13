package br.com.mind5.masterData.sysEnvironment.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.sysEnvironment.dao.DaoSysenvSelect;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysenvDaoSelect extends ActionVisitorTemplateStmt<SysenvInfo> {

	public VisiSysenvDaoSelect(DeciTreeOption<SysenvInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysenvInfo> buildStmtExecHook(List<DaoStmtExecOption<SysenvInfo>> stmtOptions) {
		return new DaoSysenvSelect(stmtOptions);
	}
}
