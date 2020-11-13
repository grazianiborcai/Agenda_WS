package br.com.mind5.masterData.materialSubgroup.model.action;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatubupMergeMatubuparch extends ActionStdTemplate<MatubupInfo> {

	public StdMatubupMergeMatubuparch(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatubupInfo> buildVisitorHook(DeciTreeOption<MatubupInfo> option) {
		return new VisiMatubupMergeMatubuparch(option);
	}
}
