package br.com.mind5.discount.discountCouponItem.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.discount.discountCouponItem.dao.DisoupemDaoUpdate;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoupemVisiDaoUpdate extends ActionVisitorTemplateStmt<DisoupemInfo> {

	public DisoupemVisiDaoUpdate(DeciTreeOption<DisoupemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DisoupemInfo> buildStmtExecHook(List<DaoStmtExecOption<DisoupemInfo>> stmtOptions) {
		return new DisoupemDaoUpdate(stmtOptions);
	}
}
