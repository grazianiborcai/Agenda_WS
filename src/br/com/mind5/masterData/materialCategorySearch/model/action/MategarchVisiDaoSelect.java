package br.com.mind5.masterData.materialCategorySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialCategorySearch.dao.MategarchDaoSelect;
import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MategarchVisiDaoSelect extends ActionVisitorTemplateStmt<MategarchInfo> {

	public MategarchVisiDaoSelect(DeciTreeOption<MategarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MategarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MategarchInfo>> stmtOptions) {
		return new MategarchDaoSelect(stmtOptions);
	}
}
