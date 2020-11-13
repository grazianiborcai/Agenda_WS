package br.com.mind5.masterData.language.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.language.dao.DaoLanguSelect;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiLanguDaoSelect extends ActionVisitorTemplateStmt<LanguInfo> {

	public VisiLanguDaoSelect(DeciTreeOption<LanguInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<LanguInfo> buildStmtExecHook(List<DaoStmtExecOption<LanguInfo>> stmtOptions) {
		return new DaoLanguSelect(stmtOptions);
	}
}
