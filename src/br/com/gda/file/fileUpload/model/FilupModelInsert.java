package br.com.gda.file.fileUpload.model;

import javax.servlet.http.HttpServletRequest;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.model.decisionTree.RootFilupInsert;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FilupModelInsert extends ModelTemplate<FilupInfo> {

	public FilupModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, FilupInfo.class);
	}
	
	
	
	@Override protected DeciTree<FilupInfo> getDecisionTreeHook(DeciTreeOption<FilupInfo> option) {
		return new RootFilupInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
