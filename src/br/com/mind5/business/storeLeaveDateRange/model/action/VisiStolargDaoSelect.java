package br.com.mind5.business.storeLeaveDateRange.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.dao.DaoStolargSelect;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolargDaoSelect extends ActionVisitorTemplateStmt<StolargInfo> {

	public VisiStolargDaoSelect(DeciTreeOption<StolargInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StolargInfo> buildStmtExecHook(List<DaoStmtExecOption<StolargInfo>> stmtOptions) {
		return new DaoStolargSelect(stmtOptions);
	}
}
