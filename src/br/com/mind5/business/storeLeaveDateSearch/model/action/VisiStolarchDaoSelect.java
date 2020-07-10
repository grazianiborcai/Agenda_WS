package br.com.mind5.business.storeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.dao.DaoStolarchSelect;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolarchDaoSelect extends ActionVisitorTemplateStmtV2<StolarchInfo> {

	public VisiStolarchDaoSelect(DeciTreeOption<StolarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StolarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StolarchInfo>> stmtOptions) {
		return new DaoStolarchSelect(stmtOptions);
	}
}
