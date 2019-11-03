package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.LazyAddresnapMergeCountry;
import br.com.mind5.business.addressSnapshot.model.action.LazyAddresnapMergeForm;
import br.com.mind5.business.addressSnapshot.model.action.LazyAddresnapNodeState;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapMergeToSelect;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootAddresnapSelect extends DeciTreeReadTemplate<AddresnapInfo> {
	
	public RootAddresnapSelect(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddresnapInfo> buildDecisionCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		List<ModelChecker<AddresnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddresnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddresnapCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> select = new StdAddresnapMergeToSelect(option);		
		ActionLazy<AddresnapInfo> mergeForm = new LazyAddresnapMergeForm(option.conn, option.schemaName);
		ActionLazy<AddresnapInfo> mergeCountry = new LazyAddresnapMergeCountry(option.conn, option.schemaName);
		ActionLazy<AddresnapInfo> mergeState = new LazyAddresnapNodeState(option.conn, option.schemaName);
		
		
		select.addPostAction(mergeForm);
		mergeForm.addPostAction(mergeCountry);
		mergeCountry.addPostAction(mergeState);
		
		actions.add(select);			
		return actions;
	}
}
