package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.checker.PetCheckAuthOwner;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PetNodeSearchAuthL2 extends DeciTreeTemplateWrite<PetInfo> {
	
	public PetNodeSearchAuthL2(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetInfo> buildCheckerHook(DeciTreeOption<PetInfo> option) {
		List<ModelChecker<PetInfo>> queue = new ArrayList<>();		
		ModelChecker<PetInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PetCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnPassedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> success = new ActionStdSuccessCommom<PetInfo>(option);
		
		actions.add(success);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnFailedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> nodeL3 = new PetNodeSearchAuthL3(option).toAction();
		
		actions.add(nodeL3);
		return actions;
	}
}
