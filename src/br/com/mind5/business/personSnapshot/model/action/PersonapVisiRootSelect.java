package br.com.mind5.business.personSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.PersonapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonapVisiRootSelect extends ActionVisitorTemplateAction<PersonapInfo, PersonapInfo> {

	public PersonapVisiRootSelect(DeciTreeOption<PersonapInfo> option) {
		super(option, PersonapInfo.class, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return PersonapRootSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> toBaseClassHook(List<PersonapInfo> baseInfos, List<PersonapInfo> results) {
		return results;
	}
}
