package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootDelete;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiPhoneDelete extends ActionVisitorTemplateAction<PeregInfo, PhoneInfo> {
	
	public PeregVisiPhoneDelete(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootDelete.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<PeregInfo> recordInfos) {
		return PhoneCopier.copyFromPereg(recordInfos);
	}
	
	
	
	@Override protected List<PeregInfo> toBaseClassHook(List<PeregInfo> baseInfos, List<PhoneInfo> results) {
		return baseInfos;
	}
}
