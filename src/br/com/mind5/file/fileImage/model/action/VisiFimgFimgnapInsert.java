package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.fileImageSnapshot.model.decisionTree.RootFimgnapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgFimgnapInsert extends ActionVisitorTemplateAction<FimgInfo, FimgnapInfo> {
	
	public VisiFimgFimgnapInsert(DeciTreeOption<FimgInfo> option) {
		super(option, FimgInfo.class, FimgnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgnapInfo>> getTreeClassHook() {
		return RootFimgnapInsert.class;
	}
	
	
	
	@Override protected List<FimgInfo> toBaseClassHook(List<FimgInfo> baseInfos, List<FimgnapInfo> results) {
		return FimgMerger.mergeWithFimgnap(baseInfos, results);
	}
}
