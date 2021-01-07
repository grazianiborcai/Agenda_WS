package br.com.mind5.config.sysDistrictSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.config.sysDistrictSearch.dao.DaoSysdistrSelect;
import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysdistrDaoSelect extends ActionVisitorTemplateStmt<SysdistrInfo> {

	public VisiSysdistrDaoSelect(DeciTreeOption<SysdistrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysdistrInfo> buildStmtExecHook(List<DaoStmtExecOption<SysdistrInfo>> stmtOptions) {
		return new DaoSysdistrSelect(stmtOptions);
	}
}
