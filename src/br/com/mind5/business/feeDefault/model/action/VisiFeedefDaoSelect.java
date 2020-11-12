package br.com.mind5.business.feeDefault.model.action;

import java.util.List;

import br.com.mind5.business.feeDefault.dao.DaoFeedefSelect;
import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFeedefDaoSelect extends ActionVisitorTemplateStmtV2<FeedefInfo> {

	public VisiFeedefDaoSelect(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FeedefInfo> buildStmtExecHook(List<DaoStmtExecOption<FeedefInfo>> stmtOptions) {
		return new DaoFeedefSelect(stmtOptions);
	}
}
