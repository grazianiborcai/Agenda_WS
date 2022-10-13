package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootUpdate;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiPersonUpdate extends ActionVisitorTemplateAction<PeregInfo, PersonInfo> {
	public PeregVisiPersonUpdate(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootUpdate.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<PeregInfo> baseInfos) {
		return PersonCopier.copyFromPereg(baseInfos);
	}
	
	
	
	@Override protected List<PeregInfo> toBaseClassHook(List<PeregInfo> baseInfos, List<PersonInfo> results) {
		return PeregMerger.mergeWithPerson(baseInfos, results);
	}
}
