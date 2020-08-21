package br.com.mind5.masterData.materialSubgroup.model.action;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatubupMergeMatouparch extends ActionStdTemplateV2<MatubupInfo> {

	public StdMatubupMergeMatouparch(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatubupInfo> buildVisitorHook(DeciTreeOption<MatubupInfo> option) {
		return new VisiMatubupMergeMatouparch(option);
	}
}
