package br.com.gda.file.fileUpload.model;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.model.decisionTree.RootFilupDelete;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FilupModelDelete extends ModelTemplate<FilupInfo> {

	public FilupModelDelete(FilupInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<FilupInfo> getDecisionTreeHook(DeciTreeOption<FilupInfo> option) {
		return new RootFilupDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
