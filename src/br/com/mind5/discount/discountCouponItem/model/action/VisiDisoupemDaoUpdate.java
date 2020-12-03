package br.com.mind5.discount.discountCouponItem.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.discount.discountCouponItem.dao.DaoDisoupemUpdate;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoupemDaoUpdate extends ActionVisitorTemplateStmt<DisoupemInfo> {

	public VisiDisoupemDaoUpdate(DeciTreeOption<DisoupemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DisoupemInfo> buildStmtExecHook(List<DaoStmtExecOption<DisoupemInfo>> stmtOptions) {
		return new DaoDisoupemUpdate(stmtOptions);
	}
}
