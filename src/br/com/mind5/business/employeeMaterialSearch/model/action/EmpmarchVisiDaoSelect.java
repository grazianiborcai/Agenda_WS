package br.com.mind5.business.employeeMaterialSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.dao.EmpmarchDaoSelect;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmarchVisiDaoSelect extends ActionVisitorTemplateStmt<EmpmarchInfo> {

	public EmpmarchVisiDaoSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpmarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpmarchInfo>> stmtOptions) {
		return new EmpmarchDaoSelect(stmtOptions);
	}
}
