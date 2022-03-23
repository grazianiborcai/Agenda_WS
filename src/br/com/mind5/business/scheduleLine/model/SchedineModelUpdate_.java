package br.com.mind5.business.scheduleLine.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.SchedineRootUpdate_;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineModelUpdate_ extends ModelTemplate<SchedineInfo> {

	public SchedineModelUpdate_(String incomingData, HttpServletRequest request) {
		super(incomingData, request, SchedineInfo.class);
	}
	
	
	
	@Override protected DeciTree<SchedineInfo> getDecisionTreeHook(DeciTreeOption<SchedineInfo> option) {
		return new SchedineRootUpdate_(option);
	}
}
