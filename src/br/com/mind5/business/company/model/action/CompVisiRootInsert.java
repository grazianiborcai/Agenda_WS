package br.com.mind5.business.company.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.CompRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompVisiRootInsert extends ActionVisitorTemplateAction<CompInfo, CompInfo> {

	public CompVisiRootInsert(DeciTreeOption<CompInfo> option) {
		super(option, CompInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return CompRootInsert.class;
	}
	
	
	
	@Override protected List<CompInfo> toBaseClassHook(List<CompInfo> baseInfos, List<CompInfo> results) {
		return results;
	}
}
