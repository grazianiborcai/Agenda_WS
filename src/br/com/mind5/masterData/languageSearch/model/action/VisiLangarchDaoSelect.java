package br.com.mind5.masterData.languageSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.languageSearch.dao.DaoLangarchSelect;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiLangarchDaoSelect extends ActionVisitorTemplateStmt<LangarchInfo> {

	public VisiLangarchDaoSelect(DeciTreeOption<LangarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<LangarchInfo> buildStmtExecHook(List<DaoStmtExecOption<LangarchInfo>> stmtOptions) {
		return new DaoLangarchSelect(stmtOptions);
	}
}
