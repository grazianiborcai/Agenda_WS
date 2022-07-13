package br.com.mind5.file.sysFileImage.model;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.decisionTree.FimgysRootInsertGroup;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysModelInsertMat extends ModelTemplate<FimgysInfo> {

	public FimgysModelInsertMat(FimgysInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<FimgysInfo> getDecisionTreeHook(DeciTreeOption<FimgysInfo> option) {
		return new FimgysRootInsertGroup(option);
	}
}
