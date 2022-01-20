package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.LazyPetNodeUpdateAuthL1;
import br.com.mind5.business.pet.model.action.LazyPetRootDelete;
import br.com.mind5.business.pet.model.action.StdPetMergeToSelect;
import br.com.mind5.business.pet.model.checker.PetCheckDelete;
import br.com.mind5.business.pet.model.checker.PetCheckExist;
import br.com.mind5.business.pet.model.checker.PetCheckLangu;
import br.com.mind5.business.pet.model.checker.PetCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPetDeleteAuth extends DeciTreeTemplateWrite<PetInfo> {
	
	public RootPetDeleteAuth(DeciTreeOption<PetInfo> option) {
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
		checker = new PetCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PetCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PetCheckOwner(checkerOption);
		queue.add(checker);	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PetCheckExist(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueue<PetInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnPassedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> select = new StdPetMergeToSelect(option);
		ActionLazy<PetInfo> nodeAuth = new LazyPetNodeUpdateAuthL1(option.conn, option.schemaName);
		ActionLazy<PetInfo> delete = new LazyPetRootDelete(option.conn, option.schemaName);
		
		select.addPostAction(nodeAuth);
		nodeAuth.addPostAction(delete);	
		
		actions.add(select);
		return actions;
	}
}
