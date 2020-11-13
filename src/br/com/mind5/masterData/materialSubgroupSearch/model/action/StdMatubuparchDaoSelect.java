package br.com.mind5.masterData.materialSubgroupSearch.model.action;

import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatubuparchDaoSelect extends ActionStdTemplate<MatubuparchInfo> {

	public StdMatubuparchDaoSelect(DeciTreeOption<MatubuparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatubuparchInfo> buildVisitorHook(DeciTreeOption<MatubuparchInfo> option) {
		return new VisiMatubuparchDaoSelect(option);
	}
}
