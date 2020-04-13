package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.RootPhonapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhoneInsertPhonap extends ActionVisitorTemplateActionV2<PhoneInfo, PhonapInfo> {

	public VisiPhoneInsertPhonap(DeciTreeOption<PhoneInfo> option) {
		super(option, PhoneInfo.class, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return RootPhonapInsert.class;
	}
	
	
	
	protected List<PhoneInfo> toBaseClassHook(List<PhoneInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		return PhoneMerger.mergeWithPhonap(baseInfos, selectedInfos);
	}
}
