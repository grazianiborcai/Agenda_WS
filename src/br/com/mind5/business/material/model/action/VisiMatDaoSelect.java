package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.dao.DaoMatSelect;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatDaoSelect extends ActionVisitorTemplateStmtV2<MatInfo> {

	public VisiMatDaoSelect(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatInfo> buildStmtExecHook(List<DaoStmtExecOption<MatInfo>> stmtOptions) {
		return new DaoMatSelect(stmtOptions);
	}
}
