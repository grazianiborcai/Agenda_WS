package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootDelete;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiPhoneDelete extends ActionVisitorTemplateAction<CusInfo, PhoneInfo> {
	
	public CusVisiPhoneDelete(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootDelete.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return PhoneCopier.copyFromCus(recordInfos);
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<PhoneInfo> results) {
		return baseInfos;
	}
}
