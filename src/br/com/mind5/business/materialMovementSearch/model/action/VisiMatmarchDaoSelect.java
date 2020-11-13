package br.com.mind5.business.materialMovementSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialMovementSearch.dao.DaoMatmarchSelect;
import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmarchDaoSelect extends ActionVisitorTemplateStmtV2<MatmarchInfo> {

	public VisiMatmarchDaoSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatmarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatmarchInfo>> stmtOptions) {
		return new DaoMatmarchSelect(stmtOptions);
	}
}
