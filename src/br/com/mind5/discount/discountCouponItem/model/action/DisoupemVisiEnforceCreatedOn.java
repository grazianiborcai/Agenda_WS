package br.com.mind5.discount.discountCouponItem.model.action;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.info.DisoupemSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoupemVisiEnforceCreatedOn extends ActionVisitorTemplateEnforce<DisoupemInfo> {
	
	public DisoupemVisiEnforceCreatedOn(DeciTreeOption<DisoupemInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected DisoupemInfo enforceHook(DisoupemInfo recordInfo) {
		InfoSetter<DisoupemInfo> attrSetter = new DisoupemSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
