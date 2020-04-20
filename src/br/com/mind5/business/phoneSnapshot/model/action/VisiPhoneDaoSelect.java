package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.dao.DaoPhonapSelect;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonapDaoSelect extends ActionVisitorTemplateStmtV2<PhonapInfo>{

	public VisiPhonapDaoSelect(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PhonapInfo> buildStmtExecHook(List<DaoStmtExecOption<PhonapInfo>> stmtOptions) {
		return new DaoPhonapSelect(stmtOptions);
	}
}
