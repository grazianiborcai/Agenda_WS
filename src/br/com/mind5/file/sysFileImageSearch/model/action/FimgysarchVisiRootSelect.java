package br.com.mind5.file.sysFileImageSearch.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.model.decisionTree.FimgysarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysarchVisiRootSelect extends ActionVisitorTemplateAction<FimgysarchInfo, FimgysarchInfo> {

	public FimgysarchVisiRootSelect(DeciTreeOption<FimgysarchInfo> option) {
		super(option, FimgysarchInfo.class, FimgysarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgysarchInfo>> getTreeClassHook() {
		return FimgysarchRootSelect.class;
	}
	
	
	
	@Override protected List<FimgysarchInfo> toBaseClassHook(List<FimgysarchInfo> baseInfos, List<FimgysarchInfo> results) {
		return results;
	}
}
