package br.com.gda.file.fileImage.model;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.decisionTree.RootFimgDelete;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FimgModelDelete extends ModelTemplate<FimgInfo> {

	public FimgModelDelete(FimgInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<FimgInfo> getDecisionTreeHook(DeciTreeOption<FimgInfo> option) {
		return new RootFimgDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
