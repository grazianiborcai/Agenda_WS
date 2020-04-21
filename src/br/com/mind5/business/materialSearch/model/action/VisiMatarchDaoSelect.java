package br.com.mind5.business.materialSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialSearch.dao.DaoMatarchSelect;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatarchDaoSelect extends ActionVisitorTemplateStmtV2<MatarchInfo>{

	public VisiMatarchDaoSelect(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatarchInfo>> stmtOptions) {
		return new DaoMatarchSelect(stmtOptions);
	}

}
