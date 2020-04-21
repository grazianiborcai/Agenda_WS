package br.com.mind5.masterData.materialGroupSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialGroupSearch.dao.DaoMatouparchSelect;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatouparchDaoSelect extends ActionVisitorTemplateStmtV2<MatouparchInfo>{

	public VisiMatouparchDaoSelect(DeciTreeOption<MatouparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatouparchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatouparchInfo>> stmtOptions) {
		return new DaoMatouparchSelect(stmtOptions);
	}
}
