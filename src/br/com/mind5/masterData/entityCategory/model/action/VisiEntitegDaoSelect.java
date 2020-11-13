package br.com.mind5.masterData.entityCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.entityCategory.dao.DaoEntitegSelect;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEntitegDaoSelect extends ActionVisitorTemplateStmt<EntitegInfo> {

	public VisiEntitegDaoSelect(DeciTreeOption<EntitegInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EntitegInfo> buildStmtExecHook(List<DaoStmtExecOption<EntitegInfo>> stmtOptions) {
		return new DaoEntitegSelect(stmtOptions);
	}
}
