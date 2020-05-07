package br.com.mind5.masterData.refundPolicyGroupHeader.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupHeader.dao.DaoRefugraderSelect;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugraderDaoSelect extends ActionVisitorTemplateStmtV2<RefugraderInfo>{

	public VisiRefugraderDaoSelect(DeciTreeOption<RefugraderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefugraderInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugraderInfo>> stmtOptions) {
		return new DaoRefugraderSelect(stmtOptions);
	}
}
