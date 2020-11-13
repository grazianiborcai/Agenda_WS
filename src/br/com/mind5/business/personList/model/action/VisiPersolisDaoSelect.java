package br.com.mind5.business.personList.model.action;

import java.util.List;

import br.com.mind5.business.personList.dao.DaoPersolisSelect;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersolisDaoSelect extends ActionVisitorTemplateStmt<PersolisInfo> {

	public VisiPersolisDaoSelect(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PersolisInfo> buildStmtExecHook(List<DaoStmtExecOption<PersolisInfo>> stmtOptions) {
		return new DaoPersolisSelect(stmtOptions);
	}
}
