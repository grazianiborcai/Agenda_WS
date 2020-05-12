package br.com.mind5.business.personList.model.action;

import java.util.List;

import br.com.mind5.business.personList.dao.DaoPersolisSelect;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersolisDaoSelect extends ActionVisitorTemplateStmtV2<PersolisInfo> {

	public VisiPersolisDaoSelect(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PersolisInfo> buildStmtExecHook(List<DaoStmtExecOption<PersolisInfo>> stmtOptions) {
		return new DaoPersolisSelect(stmtOptions);
	}
}
