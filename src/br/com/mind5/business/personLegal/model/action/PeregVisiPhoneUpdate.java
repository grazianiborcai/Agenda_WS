package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregMerger;
import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootUpdateLegalPerson;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiPhoneUpdate extends ActionVisitorTemplateAction<PeregInfo, PhoneInfo> {
	public PeregVisiPhoneUpdate(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootUpdateLegalPerson.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<PeregInfo> baseInfos) {
		return PhoneCopier.copyFromPereg(baseInfos);
	}
	
	
	
	@Override protected List<PeregInfo> toBaseClassHook(List<PeregInfo> baseInfos, List<PhoneInfo> results) {
		return PeregMerger.mergeWithPhone(baseInfos, results);
	}
}
