package br.com.mind5.masterData.entityCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.entityCategory.dao.DaoEntitegSelect;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEntitegDaoSelect extends ActionVisitorTemplateStmtV2<EntitegInfo> {

	public VisiEntitegDaoSelect(DeciTreeOption<EntitegInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EntitegInfo> buildStmtExecHook(List<DaoStmtExecOption<EntitegInfo>> stmtOptions) {
		return new DaoEntitegSelect(stmtOptions);
	}
}
