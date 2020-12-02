package br.com.mind5.discount.discountStore.model.action;

import java.util.List;

import br.com.mind5.discount.discountStore.dao.DaoDisoreSelect;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoreDaoSelect extends ActionVisitorTemplateStmt<DisoreInfo> {

	public VisiDisoreDaoSelect(DeciTreeOption<DisoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DisoreInfo> buildStmtExecHook(List<DaoStmtExecOption<DisoreInfo>> stmtOptions) {
		return new DaoDisoreSelect(stmtOptions);
	}
}
