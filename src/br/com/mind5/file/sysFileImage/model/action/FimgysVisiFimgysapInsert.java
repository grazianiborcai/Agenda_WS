package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysMerger;
import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.file.sysFileImageSnapshot.model.decisionTree.RootFimgysapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiFimgysapInsert extends ActionVisitorTemplateAction<FimgysInfo, FimgysapInfo> {
	
	public FimgysVisiFimgysapInsert(DeciTreeOption<FimgysInfo> option) {
		super(option, FimgysInfo.class, FimgysapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgysapInfo>> getTreeClassHook() {
		return RootFimgysapInsert.class;
	}
	
	
	
	@Override protected List<FimgysInfo> toBaseClassHook(List<FimgysInfo> baseInfos, List<FimgysapInfo> results) {
		return FimgysMerger.mergeWithFimgysap(baseInfos, results);
	}
}
