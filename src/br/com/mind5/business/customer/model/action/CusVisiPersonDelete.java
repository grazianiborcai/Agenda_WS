package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootDeleteCus;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiPersonDelete extends ActionVisitorTemplateAction<CusInfo, PersonInfo> {
	public CusVisiPersonDelete(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootDeleteCus.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return PersonInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<PersonInfo> results) {
		return baseInfos;
	}
}
