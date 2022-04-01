package br.com.mind5.business.company.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.CompNodeCnpjL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompVisiNodeCnpjL1 extends ActionVisitorTemplateAction<CompInfo, CompInfo> {

	public CompVisiNodeCnpjL1(DeciTreeOption<CompInfo> option) {
		super(option, CompInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return CompNodeCnpjL1.class;
	}
	
	
	
	@Override protected List<CompInfo> toBaseClassHook(List<CompInfo> baseInfos, List<CompInfo> results) {
		return results;
	}
}
