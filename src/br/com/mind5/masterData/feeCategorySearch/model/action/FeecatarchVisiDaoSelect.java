package br.com.mind5.masterData.feeCategorySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.feeCategorySearch.dao.FeecatarchDaoSelect;
import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeecatarchVisiDaoSelect extends ActionVisitorTemplateStmt<FeecatarchInfo> {

	public FeecatarchVisiDaoSelect(DeciTreeOption<FeecatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FeecatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FeecatarchInfo>> stmtOptions) {
		return new FeecatarchDaoSelect(stmtOptions);
	}
}
