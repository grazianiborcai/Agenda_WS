package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.AddresnapVisiMergeUselis;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckHasUser;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddresnapNodeUselis extends DeciTreeTemplateWrite<AddresnapInfo> {
	
	public AddresnapNodeUselis(DeciTreeOption<AddresnapInfo> option) {
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
		checker = new AddresnapCheckHasUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> mergeUselis = new ActionStdCommom<AddresnapInfo>(option, AddresnapVisiMergeUselis.class);	
		
		actions.add(mergeUselis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnFailedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> nodeEmp = new AddresnapNodeEmplis(option).toAction();	
		
		actions.add(nodeEmp);			
		return actions;
	}
}
