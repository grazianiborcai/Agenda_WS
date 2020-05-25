package br.com.mind5.business.customerList.model.action;

import java.util.List;

import br.com.mind5.business.customerList.dao.DaoCuslisSelect;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCuslisDaoSelect extends ActionVisitorTemplateStmtV2<CuslisInfo> {

	public VisiCuslisDaoSelect(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CuslisInfo> buildStmtExecHook(List<DaoStmtExecOption<CuslisInfo>> stmtOptions) {
		return new DaoCuslisSelect(stmtOptions);
	}
}
