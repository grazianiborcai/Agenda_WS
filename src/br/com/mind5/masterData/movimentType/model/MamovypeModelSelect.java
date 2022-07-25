package br.com.mind5.masterData.movimentType.model;

import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.decisionTree.MamovypeRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MamovypeModelSelect extends ModelTemplate<MamovypeInfo> {

	public MamovypeModelSelect(MamovypeInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MamovypeInfo> getDecisionTreeHook(DeciTreeOption<MamovypeInfo> option) {
		return new MamovypeRootSelect(option);
	}
}
