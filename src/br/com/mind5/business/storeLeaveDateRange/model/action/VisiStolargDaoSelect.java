package br.com.mind5.business.storeLeaveDateRange.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.dao.DaoStolargSelect;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolargDaoSelect extends ActionVisitorTemplateStmt<StolargInfo> {

	public VisiStolargDaoSelect(DeciTreeOption<StolargInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StolargInfo> buildStmtExecHook(List<DaoStmtExecOption<StolargInfo>> stmtOptions) {
		return new DaoStolargSelect(stmtOptions);
	}
}
