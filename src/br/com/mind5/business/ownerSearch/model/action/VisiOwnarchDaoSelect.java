package br.com.mind5.business.ownerSearch.model.action;

import java.util.List;

import br.com.mind5.business.ownerSearch.dao.DaoOwnarchSelect;
import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnarchDaoSelect extends ActionVisitorTemplateStmtV2<OwnarchInfo> {

	public VisiOwnarchDaoSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OwnarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnarchInfo>> stmtOptions) {
		return new DaoOwnarchSelect(stmtOptions);
	}
}
