package br.com.mind5.file.fileImageDecorated.model.action;

import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.decisionTree.FimecoRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimecoVisiRootSelect extends ActionVisitorTemplateAction<FimecoInfo, FimecoInfo> {

	public FimecoVisiRootSelect(DeciTreeOption<FimecoInfo> option) {
		super(option, FimecoInfo.class, FimecoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimecoInfo>> getTreeClassHook() {
		return FimecoRootSelect.class;
	}
	
	
	
	@Override protected List<FimecoInfo> toBaseClassHook(List<FimecoInfo> baseInfos, List<FimecoInfo> results) {
		return results;
	}
}
