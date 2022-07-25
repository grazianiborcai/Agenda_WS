package br.com.mind5.masterData.userCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.userCategory.dao.UseregDaoSelect;
import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class VisiUseregDaoSelect extends ActionVisitorTemplateStmt<UseregInfo> {

	public VisiUseregDaoSelect(DeciTreeOption<UseregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UseregInfo> buildStmtExecHook(List<DaoStmtExecOption<UseregInfo>> stmtOptions) {
		return new UseregDaoSelect(stmtOptions);
	}
}
