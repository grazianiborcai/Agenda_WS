package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.fileImageSnapshot.model.decisionTree.RootFimgnapInsert;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysFimgnapInsert extends ActionVisitorTemplateAction<FimgysInfo, FimgnapInfo> {
	
	public VisiFimgysFimgnapInsert(DeciTreeOption<FimgysInfo> option) {
		super(option, FimgysInfo.class, FimgnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgnapInfo>> getTreeClassHook() {
		return RootFimgnapInsert.class;
	}
	
	
	
	@Override protected List<FimgysInfo> toBaseClassHook(List<FimgysInfo> baseInfos, List<FimgnapInfo> results) {
		return FimgysMerger.mergeWithFimgnap(baseInfos, results);
	}
}
