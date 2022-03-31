package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.AddresnapVisiNodeState;
import br.com.mind5.business.addressSnapshot.model.action.AddresnapVisiMergeCountry;
import br.com.mind5.business.addressSnapshot.model.action.AddresnapVisiMergeFormess;
import br.com.mind5.business.addressSnapshot.model.action.AddresnapVisiMergeToSelect;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddresnapRootSelect extends DeciTreeTemplateWrite<AddresnapInfo> {
	
	public AddresnapRootSelect(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddresnapInfo> buildCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		List<ModelChecker<AddresnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddresnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddresnapCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> select = new ActionStdCommom<AddresnapInfo>(option, AddresnapVisiMergeToSelect.class);		
		ActionLazy<AddresnapInfo> mergeFormess = new ActionLazyCommom<AddresnapInfo>(option, AddresnapVisiMergeFormess.class);
		ActionLazy<AddresnapInfo> mergeCountry = new ActionLazyCommom<AddresnapInfo>(option, AddresnapVisiMergeCountry.class);
		ActionLazy<AddresnapInfo> mergeState = new ActionLazyCommom<AddresnapInfo>(option, AddresnapVisiNodeState.class);
		
		
		select.addPostAction(mergeFormess);
		mergeFormess.addPostAction(mergeCountry);
		mergeCountry.addPostAction(mergeState);
		
		actions.add(select);			
		return actions;
	}
}
