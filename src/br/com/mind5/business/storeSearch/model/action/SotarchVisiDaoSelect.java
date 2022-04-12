package br.com.mind5.business.storeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeSearch.dao.SotarchDaoSelect;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SotarchVisiDaoSelect extends ActionVisitorTemplateStmt<SotarchInfo> {

	public SotarchVisiDaoSelect(DeciTreeOption<SotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SotarchInfo> buildStmtExecHook(List<DaoStmtExecOption<SotarchInfo>> stmtOptions) {
		return new SotarchDaoSelect(stmtOptions);
	}
}
