package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.decisionTree.RootPerbioDeletePerson;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonPerbioDelete extends ActionVisitorTemplateAction<PersonInfo, PerbioInfo> {
	
	public VisiPersonPerbioDelete(DeciTreeOption<PersonInfo> option) {
		super(option, PersonInfo.class, PerbioInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbioInfo>> getTreeClassHook() {
		return RootPerbioDeletePerson.class;
	}
	
	
	
	@Override protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PerbioInfo> results) {
		return baseInfos;
	}
}
