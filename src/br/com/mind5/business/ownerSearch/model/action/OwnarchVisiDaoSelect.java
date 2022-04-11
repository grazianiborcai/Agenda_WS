package br.com.mind5.business.ownerSearch.model.action;

import java.util.List;

import br.com.mind5.business.ownerSearch.dao.OwnarchDaoSelect;
import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnarchVisiDaoSelect extends ActionVisitorTemplateStmt<OwnarchInfo> {

	public OwnarchVisiDaoSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OwnarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnarchInfo>> stmtOptions) {
		return new OwnarchDaoSelect(stmtOptions);
	}
}
