package br.com.mind5.masterData.refundPolicyGroupSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupSearch.dao.DaoRefugrarchSelect;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugrarchDaoSelect extends ActionVisitorTemplateStmtV2<RefugrarchInfo>{

	public VisiRefugrarchDaoSelect(DeciTreeOption<RefugrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefugrarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugrarchInfo>> stmtOptions) {
		return new DaoRefugrarchSelect(stmtOptions);
	}
}
