package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootUpdateCus;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiPersonUpdate extends ActionVisitorTemplateAction<CusInfo, PersonInfo> {
	public CusVisiPersonUpdate(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootUpdateCus.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<CusInfo> baseInfos) {
		return PersonCopier.copyFromCus(baseInfos);
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<PersonInfo> results) {
		return CusMerger.mergeWithPerson(baseInfos, results);
	}
}
