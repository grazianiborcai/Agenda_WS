package br.com.mind5.business.materialStockSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialStockSearch.dao.DaoMatocarchSelect;
import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatocarchDaoSelect extends ActionVisitorTemplateStmtV2<MatocarchInfo> {

	public VisiMatocarchDaoSelect(DeciTreeOption<MatocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatocarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatocarchInfo>> stmtOptions) {
		return new DaoMatocarchSelect(stmtOptions);
	}
}
