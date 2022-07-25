package br.com.mind5.discount.discountCouponItem.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.model.action.DisoupemVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoupemCheckExist extends ModelCheckerTemplateAction<DisoupemInfo, DisoupemInfo> {
	
	public DisoupemCheckExist(ModelCheckerOption option) {
		super(option, DisoupemInfo.class);
	}
	
	
	
	@Override protected ActionStd<DisoupemInfo> buildActionHook(DeciTreeOption<DisoupemInfo> option) {
		ActionStd<DisoupemInfo> select = new ActionStdCommom<DisoupemInfo>(option, DisoupemVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.DISCOUNT_COUPON_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_COUPON_NOT_FOUND;
	}
}
