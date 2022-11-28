package br.com.mind5.masterData.materialGroupOwner.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.decisionTree.MatoupowRootUpsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowModelUpsert extends ModelTemplate<MatoupowInfo> {

	public MatoupowModelUpsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, MatoupowInfo.class);
	}
	
	
	
	@Override protected DeciTree<MatoupowInfo> getDecisionTreeHook(DeciTreeOption<MatoupowInfo> option) {
		return new MatoupowRootUpsert(option);
	}
}
