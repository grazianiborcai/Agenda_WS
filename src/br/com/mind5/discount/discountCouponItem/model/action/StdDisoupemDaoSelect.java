package br.com.mind5.discount.discountCouponItem.model.action;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDisoupemDaoSelect extends ActionStdTemplate<DisoupemInfo> {

	public StdDisoupemDaoSelect(DeciTreeOption<DisoupemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<DisoupemInfo> buildVisitorHook(DeciTreeOption<DisoupemInfo> option) {
		return new VisiDisoupemDaoSelect(option);
	}
}
