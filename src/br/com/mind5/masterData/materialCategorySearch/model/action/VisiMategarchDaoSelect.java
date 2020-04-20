package br.com.mind5.masterData.materialCategorySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialCategorySearch.dao.DaoMategarchSelect;
import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMategarchDaoSelect extends ActionVisitorTemplateStmtV2<MategarchInfo>{

	public VisiMategarchDaoSelect(DeciTreeOption<MategarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MategarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MategarchInfo>> stmtOptions) {
		return new DaoMategarchSelect(stmtOptions);
	}
}
