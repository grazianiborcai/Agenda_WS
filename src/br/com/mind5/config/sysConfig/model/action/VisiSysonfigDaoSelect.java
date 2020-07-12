package br.com.mind5.config.sysConfig.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.config.sysConfig.dao.DaoSysonfigSelect;
import br.com.mind5.config.sysConfig.info.SysonfigInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysonfigDaoSelect extends ActionVisitorTemplateStmtV2<SysonfigInfo> {

	public VisiSysonfigDaoSelect(DeciTreeOption<SysonfigInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SysonfigInfo> buildStmtExecHook(List<DaoStmtExecOption<SysonfigInfo>> stmtOptions) {
		return new DaoSysonfigSelect(stmtOptions);
	}
}
