package br.com.mind5.business.scheduleDayData.model;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.decisionTree.RootSchedaytaSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedaytaModelSelect extends ModelTemplate<SchedaytaInfo> {

	public SchedaytaModelSelect(SchedaytaInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedaytaInfo> getDecisionTreeHook(DeciTreeOption<SchedaytaInfo> option) {
		return new RootSchedaytaSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
