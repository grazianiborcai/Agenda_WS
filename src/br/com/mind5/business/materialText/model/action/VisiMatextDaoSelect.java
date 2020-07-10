package br.com.mind5.business.materialText.model.action;

import java.util.List;

import br.com.mind5.business.materialText.dao.DaoMatextSelect;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextDaoSelect extends ActionVisitorTemplateStmtV2<MatextInfo> {

	public VisiMatextDaoSelect(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatextInfo> buildStmtExecHook(List<DaoStmtExecOption<MatextInfo>> stmtOptions) {
		return new DaoMatextSelect(stmtOptions);
	}
}
