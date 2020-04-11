package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.LazyAddresnapMergeCountry;
import br.com.mind5.business.addressSnapshot.model.action.LazyAddresnapMergeForm;
import br.com.mind5.business.addressSnapshot.model.action.LazyAddresnapNodeState;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapMergeToSelect;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootAddresnapSelect extends DeciTreeTemplateRead<AddresnapInfo> {
	
	public RootAddresnapSelect(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AddresnapInfo> buildCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		List<ModelCheckerV1<AddresnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AddresnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddresnapCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStdV1<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<AddresnapInfo> select = new StdAddresnapMergeToSelect(option);		
		ActionLazyV1<AddresnapInfo> mergeForm = new LazyAddresnapMergeForm(option.conn, option.schemaName);
		ActionLazyV1<AddresnapInfo> mergeCountry = new LazyAddresnapMergeCountry(option.conn, option.schemaName);
		ActionLazyV1<AddresnapInfo> mergeState = new LazyAddresnapNodeState(option.conn, option.schemaName);
		
		
		select.addPostAction(mergeForm);
		mergeForm.addPostAction(mergeCountry);
		mergeCountry.addPostAction(mergeState);
		
		actions.add(select);			
		return actions;
	}
}
