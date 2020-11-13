package br.com.mind5.masterData.userCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.userCategory.dao.DaoUseregSelect;
import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiUseregDaoSelect extends ActionVisitorTemplateStmt<UseregInfo> {

	public VisiUseregDaoSelect(DeciTreeOption<UseregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<UseregInfo> buildStmtExecHook(List<DaoStmtExecOption<UseregInfo>> stmtOptions) {
		return new DaoUseregSelect(stmtOptions);
	}
}
