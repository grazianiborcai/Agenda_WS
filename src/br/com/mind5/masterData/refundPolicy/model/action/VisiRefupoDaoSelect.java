package br.com.mind5.masterData.refundPolicy.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicy.dao.DaoRefupoSelect;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupoDaoSelect extends ActionVisitorTemplateStmtV2<RefupoInfo> {

	public VisiRefupoDaoSelect(DeciTreeOption<RefupoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefupoInfo> buildStmtExecHook(List<DaoStmtExecOption<RefupoInfo>> stmtOptions) {
		return new DaoRefupoSelect(stmtOptions);
	}
}
