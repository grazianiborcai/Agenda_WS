package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootUpsertdel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiPhoneUpsert extends ActionVisitorTemplateAction<CusInfo, PhoneInfo> {
	public CusVisiPhoneUpsert(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootUpsertdel.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<CusInfo> baseInfos) {
		return PhoneCopier.copyFromCus(baseInfos);
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<PhoneInfo> results) {
		return CusMerger.mergeWithPhone(baseInfos, results);
	}
}
