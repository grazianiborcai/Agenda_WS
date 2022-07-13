package br.com.mind5.file.fileImageSnapshot.model.action;

import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.fileImageSnapshot.model.decisionTree.FimgnapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgnapVisiRootSelect extends ActionVisitorTemplateAction<FimgnapInfo, FimgnapInfo> {

	public FimgnapVisiRootSelect(DeciTreeOption<FimgnapInfo> option) {
		super(option, FimgnapInfo.class, FimgnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgnapInfo>> getTreeClassHook() {
		return FimgnapRootSelect.class;
	}
	
	
	
	@Override protected List<FimgnapInfo> toBaseClassHook(List<FimgnapInfo> baseInfos, List<FimgnapInfo> results) {
		return results;
	}
}
