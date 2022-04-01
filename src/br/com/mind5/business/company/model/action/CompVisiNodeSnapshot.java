package br.com.mind5.business.company.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.CompNodeSnapshot;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompVisiNodeSnapshot extends ActionVisitorTemplateAction<CompInfo, CompInfo> {

	public CompVisiNodeSnapshot(DeciTreeOption<CompInfo> option) {
		super(option, CompInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return CompNodeSnapshot.class;
	}
	
	
	
	@Override protected List<CompInfo> toBaseClassHook(List<CompInfo> baseInfos, List<CompInfo> results) {
		return results;
	}
}
