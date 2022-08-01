package br.com.mind5.masterData.languageSearch.model.action;

import java.util.List;

import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.decisionTree.LangarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LangarchVisiRootSelect extends ActionVisitorTemplateAction<LangarchInfo, LangarchInfo> {

	public LangarchVisiRootSelect(DeciTreeOption<LangarchInfo> option) {
		super(option, LangarchInfo.class, LangarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<LangarchInfo>> getTreeClassHook() {
		return LangarchRootSelect.class;
	}
	
	
	
	@Override protected List<LangarchInfo> toBaseClassHook(List<LangarchInfo> baseInfos, List<LangarchInfo> results) {
		return results;
	}
}
