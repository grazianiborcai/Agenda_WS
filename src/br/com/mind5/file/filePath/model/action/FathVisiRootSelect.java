package br.com.mind5.file.filePath.model.action;

import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.decisionTree.FathRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FathVisiRootSelect extends ActionVisitorTemplateAction<FathInfo, FathInfo> {

	public FathVisiRootSelect(DeciTreeOption<FathInfo> option) {
		super(option, FathInfo.class, FathInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FathInfo>> getTreeClassHook() {
		return FathRootSelect.class;
	}
	
	
	
	@Override protected List<FathInfo> toBaseClassHook(List<FathInfo> baseInfos, List<FathInfo> results) {
		return results;
	}
}
