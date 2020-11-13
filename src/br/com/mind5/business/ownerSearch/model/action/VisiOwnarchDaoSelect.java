package br.com.mind5.business.ownerSearch.model.action;

import java.util.List;

import br.com.mind5.business.ownerSearch.dao.DaoOwnarchSelect;
import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnarchDaoSelect extends ActionVisitorTemplateStmt<OwnarchInfo> {

	public VisiOwnarchDaoSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OwnarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnarchInfo>> stmtOptions) {
		return new DaoOwnarchSelect(stmtOptions);
	}
}
