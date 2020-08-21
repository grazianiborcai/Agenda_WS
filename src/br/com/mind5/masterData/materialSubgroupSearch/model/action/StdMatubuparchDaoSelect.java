package br.com.mind5.masterData.materialSubgroupSearch.model.action;

import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatubuparchDaoSelect extends ActionStdTemplateV2<MatubuparchInfo> {

	public StdMatubuparchDaoSelect(DeciTreeOption<MatubuparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatubuparchInfo> buildVisitorHook(DeciTreeOption<MatubuparchInfo> option) {
		return new VisiMatubuparchDaoSelect(option);
	}
}
