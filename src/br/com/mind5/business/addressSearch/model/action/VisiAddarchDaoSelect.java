package br.com.mind5.business.addressSearch.model.action;

import java.util.List;

import br.com.mind5.business.addressSearch.dao.DaoAddarchSelect;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddarchDaoSelect extends ActionVisitorTemplateStmtV2<AddarchInfo>{

	public VisiAddarchDaoSelect(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<AddarchInfo> buildStmtExecHook(List<DaoStmtExecOption<AddarchInfo>> stmtOptions) {
		return new DaoAddarchSelect(stmtOptions);
	}
}
