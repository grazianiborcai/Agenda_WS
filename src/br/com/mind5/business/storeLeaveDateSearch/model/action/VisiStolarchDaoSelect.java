package br.com.mind5.business.storeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.dao.DaoStolarchSelect;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolarchDaoSelect extends ActionVisitorTemplateStmt<StolarchInfo> {

	public VisiStolarchDaoSelect(DeciTreeOption<StolarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StolarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StolarchInfo>> stmtOptions) {
		return new DaoStolarchSelect(stmtOptions);
	}
}
