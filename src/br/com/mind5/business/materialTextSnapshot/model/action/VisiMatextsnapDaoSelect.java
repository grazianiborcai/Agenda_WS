package br.com.mind5.business.materialTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.dao.DaoMatextsnapSelect;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextsnapDaoSelect extends ActionVisitorTemplateStmtV2<MatextsnapInfo> {

	public VisiMatextsnapDaoSelect(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatextsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<MatextsnapInfo>> stmtOptions) {
		return new DaoMatextsnapSelect(stmtOptions);
	}
}
