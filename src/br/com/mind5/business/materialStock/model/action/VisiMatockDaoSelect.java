package br.com.mind5.business.materialStock.model.action;

import java.util.List;

import br.com.mind5.business.materialStock.dao.DaoMatockSelect;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatockDaoSelect extends ActionVisitorTemplateStmtV2<MatockInfo> {

	public VisiMatockDaoSelect(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatockInfo> buildStmtExecHook(List<DaoStmtExecOption<MatockInfo>> stmtOptions) {
		return new DaoMatockSelect(stmtOptions);
	}
}
