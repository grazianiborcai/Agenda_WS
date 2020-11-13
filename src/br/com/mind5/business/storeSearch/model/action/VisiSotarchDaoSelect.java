package br.com.mind5.business.storeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeSearch.dao.DaoSotarchSelect;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSotarchDaoSelect extends ActionVisitorTemplateStmt<SotarchInfo> {

	public VisiSotarchDaoSelect(DeciTreeOption<SotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SotarchInfo> buildStmtExecHook(List<DaoStmtExecOption<SotarchInfo>> stmtOptions) {
		return new DaoSotarchSelect(stmtOptions);
	}
}
