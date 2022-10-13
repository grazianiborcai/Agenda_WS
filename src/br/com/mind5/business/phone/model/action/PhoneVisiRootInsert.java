package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiRootInsert extends ActionVisitorTemplateAction<PhoneInfo, PhoneInfo> {

	public PhoneVisiRootInsert(DeciTreeOption<PhoneInfo> option) {
		super(option, PhoneInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootInsert.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toBaseClassHook(List<PhoneInfo> baseInfos, List<PhoneInfo> results) {
		return results;
	}
}
