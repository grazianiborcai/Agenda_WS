package br.com.mind5.business.companyList.model.action;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.decisionTree.ComplisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ComplisVisiRootSelect extends ActionVisitorTemplateAction<ComplisInfo, ComplisInfo> {

	public ComplisVisiRootSelect(DeciTreeOption<ComplisInfo> option) {
		super(option, ComplisInfo.class, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComplisInfo>> getTreeClassHook() {
		return ComplisRootSelect.class;
	}
	
	
	
	@Override protected List<ComplisInfo> toBaseClassHook(List<ComplisInfo> baseInfos, List<ComplisInfo> results) {
		return results;
	}
}
