package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.dao.DaoStolisSelect;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolisDaoSelect extends ActionVisitorTemplateStmtV2<StolisInfo> {

	public VisiStolisDaoSelect(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StolisInfo> buildStmtExecHook(List<DaoStmtExecOption<StolisInfo>> stmtOptions) {
		return new DaoStolisSelect(stmtOptions);
	}
}
