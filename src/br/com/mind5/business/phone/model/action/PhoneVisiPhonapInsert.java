package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.PhonapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiPhonapInsert extends ActionVisitorTemplateAction<PhoneInfo, PhonapInfo> {

	public PhoneVisiPhonapInsert(DeciTreeOption<PhoneInfo> option) {
		super(option, PhoneInfo.class, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return PhonapRootInsert.class;
	}
	
	
	
	protected List<PhoneInfo> toBaseClassHook(List<PhoneInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		return PhoneMerger.mergeWithPhonap(baseInfos, selectedInfos);
	}
}
