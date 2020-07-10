package br.com.mind5.masterData.materialTypeSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialTypeSearch.dao.DaoMatyparchSelect;
import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatyparchDaoSelect extends ActionVisitorTemplateStmtV2<MatyparchInfo> {

	public VisiMatyparchDaoSelect(DeciTreeOption<MatyparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatyparchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatyparchInfo>> stmtOptions) {
		return new DaoMatyparchSelect(stmtOptions);
	}
}
