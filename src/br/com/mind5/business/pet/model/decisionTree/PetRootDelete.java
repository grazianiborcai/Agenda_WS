package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.PetVisiNodeDefaultAfterL1;
import br.com.mind5.business.pet.model.action.PetVisiDaoDelete;
import br.com.mind5.business.pet.model.action.PetVisiMergeToSelect;
import br.com.mind5.business.pet.model.checker.PetCheckDelete;
import br.com.mind5.business.pet.model.checker.PetCheckExist;
import br.com.mind5.business.pet.model.checker.PetCheckLangu;
import br.com.mind5.business.pet.model.checker.PetCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdEmptifyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PetRootDelete extends DeciTreeTemplateWrite<PetInfo> {
	
	public PetRootDelete(DeciTreeOption<PetInfo> option) {
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
		
		ActionStd<PetInfo> select = new ActionStdCommom<PetInfo>(option, PetVisiMergeToSelect.class);
		ActionLazy<PetInfo> delete = new ActionLazyCommom<PetInfo>(option, PetVisiDaoDelete.class);
		ActionLazy<PetInfo> nodeDefault = new ActionLazyCommom<PetInfo>(option, PetVisiNodeDefaultAfterL1.class);
		ActionStd<PetInfo> emptify = new ActionStdEmptifyCommom<PetInfo>(PetInfo.class);
		
		select.addPostAction(delete);
		select.addPostAction(nodeDefault);
		
		actions.add(select);
		actions.add(emptify);
		return actions;
	}
}
