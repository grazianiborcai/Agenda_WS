package br.com.mind5.discount.discountCouponItem.model.action;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.info.DisoupemSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoupemVisiEnforceLChanged extends ActionVisitorTemplateEnforce<DisoupemInfo> {
	
	public DisoupemVisiEnforceLChanged(DeciTreeOption<DisoupemInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected DisoupemInfo enforceHook(DisoupemInfo recordInfo) {
		InfoSetter<DisoupemInfo> attrSetter = new DisoupemSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
