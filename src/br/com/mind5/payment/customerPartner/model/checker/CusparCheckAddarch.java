package br.com.mind5.payment.customerPartner.model.checker;

import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchCopier;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.AddarchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckAddarch extends ModelCheckerTemplateAction<CusparInfo, AddarchInfo> {	
	
	public CusparCheckAddarch(ModelCheckerOption option) {
		super(option, AddarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddarchInfo> buildActionHook(DeciTreeOption<AddarchInfo> option) {
		ActionStd<AddarchInfo> select = new AddarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<AddarchInfo> toActionClassHook(List<CusparInfo> recordInfos) {
		return AddarchCopier.copyFromCuspar(recordInfos);
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_INVALID_ADDRESS;
	}
}
