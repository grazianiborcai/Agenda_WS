package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialMovement.dao.DaoMatmovSelect;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovDaoSelect extends ActionVisitorTemplateStmtV2<MatmovInfo> {

	public VisiMatmovDaoSelect(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatmovInfo> buildStmtExecHook(List<DaoStmtExecOption<MatmovInfo>> stmtOptions) {
		return new DaoMatmovSelect(stmtOptions);
	}
}
