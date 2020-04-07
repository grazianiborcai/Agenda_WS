package br.com.mind5.payment.creditCard.model.checker;

import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchCopier;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.RootAddarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckAddarch extends ModelCheckerTemplateActionV2<CrecardInfo, AddarchInfo> {	
	
	public CrecardCheckAddarch(ModelCheckerOption option) {
		super(option, AddarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<AddarchInfo> buildActionHook(DeciTreeOption<AddarchInfo> option) {
		ActionStdV1<AddarchInfo> select = new RootAddarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<AddarchInfo> toActionClassHook(List<CrecardInfo> recordInfos) {
		return AddarchCopier.copyFromCrecard(recordInfos);
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_INVALID_ADDRESS;
	}
}
