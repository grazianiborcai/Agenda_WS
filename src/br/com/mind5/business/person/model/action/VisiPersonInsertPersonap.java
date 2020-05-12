package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonMerger;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.RootPersonapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonInsertPersonap extends ActionVisitorTemplateActionV2<PersonInfo, PersonapInfo> {

	public VisiPersonInsertPersonap(DeciTreeOption<PersonInfo> option) {
		super(option, PersonInfo.class, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return RootPersonapInsert.class;
	}
	
	
	
	protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		return PersonMerger.mergeWithPersonap(baseInfos, selectedInfos);
	}
}
