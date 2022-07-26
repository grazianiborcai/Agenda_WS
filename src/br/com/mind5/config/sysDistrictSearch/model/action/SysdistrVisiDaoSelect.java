package br.com.mind5.config.sysDistrictSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.config.sysDistrictSearch.dao.SysdistrDaoSelect;
import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysdistrVisiDaoSelect extends ActionVisitorTemplateStmt<SysdistrInfo> {

	public SysdistrVisiDaoSelect(DeciTreeOption<SysdistrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysdistrInfo> buildStmtExecHook(List<DaoStmtExecOption<SysdistrInfo>> stmtOptions) {
		return new SysdistrDaoSelect(stmtOptions);
	}
}
