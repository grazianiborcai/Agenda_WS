package br.com.mind5.masterData.language.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.language.dao.LanguDaoSelect;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LanguVisiDaoSelect extends ActionVisitorTemplateStmt<LanguInfo> {

	public LanguVisiDaoSelect(DeciTreeOption<LanguInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<LanguInfo> buildStmtExecHook(List<DaoStmtExecOption<LanguInfo>> stmtOptions) {
		return new LanguDaoSelect(stmtOptions);
	}
}
