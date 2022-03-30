package br.com.mind5.business.owner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootUpsertdel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerPhoneUpsert extends ActionVisitorTemplateAction<OwnerInfo, PhoneInfo> {
	
	public VisiOwnerPhoneUpsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootUpsertdel.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (OwnerInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.phones);
		}		
		
		return results;
	}
}
