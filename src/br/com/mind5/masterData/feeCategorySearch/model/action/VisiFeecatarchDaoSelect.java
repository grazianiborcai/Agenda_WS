package br.com.mind5.masterData.feeCategorySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.feeCategorySearch.dao.DaoFeecatarchSelect;
import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFeecatarchDaoSelect extends ActionVisitorTemplateStmtV2<FeecatarchInfo>{

	public VisiFeecatarchDaoSelect(DeciTreeOption<FeecatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FeecatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FeecatarchInfo>> stmtOptions) {
		return new DaoFeecatarchSelect(stmtOptions);
	}
}
