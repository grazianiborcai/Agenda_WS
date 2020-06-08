package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.dao.DaoOwnelisSelect;
import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnelisDaoSelect extends ActionVisitorTemplateStmtV2<OwnelisInfo> {

	public VisiOwnelisDaoSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OwnelisInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnelisInfo>> stmtOptions) {
		return new DaoOwnelisSelect(stmtOptions);
	}
}
