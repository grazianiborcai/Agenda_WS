package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootDelete;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiPersonDelete extends ActionVisitorTemplateAction<PeregInfo, PersonInfo> {
	public PeregVisiPersonDelete(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootDelete.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<PeregInfo> recordInfos) {
		return PersonInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected List<PeregInfo> toBaseClassHook(List<PeregInfo> baseInfos, List<PersonInfo> results) {
		return baseInfos;
	}
}
