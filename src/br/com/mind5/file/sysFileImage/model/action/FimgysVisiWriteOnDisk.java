package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileWrite.info.FriteCopier;
import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.file.fileWrite.model.decisionTree.FriteRootWriteOnDisk;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiWriteOnDisk extends ActionVisitorTemplateAction<FimgysInfo, FriteInfo> {
	
	public FimgysVisiWriteOnDisk(DeciTreeOption<FimgysInfo> option) {
		super(option, FimgysInfo.class, FriteInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FriteInfo>> getTreeClassHook() {
		return FriteRootWriteOnDisk.class;
	}
	
	
	
	@Override protected List<FriteInfo> toActionClassHook(List<FimgysInfo> baseInfos) {
		return FriteCopier.copyFromFimgys(baseInfos);
	}
	
	
	
	@Override protected List<FimgysInfo> toBaseClassHook(List<FimgysInfo> baseInfos, List<FriteInfo> results) {
		return baseInfos;
	}
}
