package br.com.mind5.masterData.countrySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countrySearch.dao.CountarchDaoSelect;
import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountarchVisiDaoSelect extends ActionVisitorTemplateStmt<CountarchInfo> {

	public CountarchVisiDaoSelect(DeciTreeOption<CountarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CountarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CountarchInfo>> stmtOptions) {
		return new CountarchDaoSelect(stmtOptions);
	}
}
