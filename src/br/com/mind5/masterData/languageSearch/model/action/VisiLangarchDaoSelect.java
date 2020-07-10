package br.com.mind5.masterData.languageSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.languageSearch.dao.DaoLangarchSelect;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiLangarchDaoSelect extends ActionVisitorTemplateStmtV2<LangarchInfo> {

	public VisiLangarchDaoSelect(DeciTreeOption<LangarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<LangarchInfo> buildStmtExecHook(List<DaoStmtExecOption<LangarchInfo>> stmtOptions) {
		return new DaoLangarchSelect(stmtOptions);
	}
}
