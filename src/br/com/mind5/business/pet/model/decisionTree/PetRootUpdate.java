package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.PetVisiDaoUpdate;
import br.com.mind5.business.pet.model.action.PetVisiEnforceLChanged;
import br.com.mind5.business.pet.model.action.PetVisiMergeToUpdate;
import br.com.mind5.business.pet.model.action.PetVisiMergeUsername;
import br.com.mind5.business.pet.model.action.PetVisiNodeDefaultAfterL1;
import br.com.mind5.business.pet.model.action.PetVisiNodeSnapshot;
import br.com.mind5.business.pet.model.action.PetVisiRootSelect;
import br.com.mind5.business.pet.model.checker.PetCheckBirthdate;
import br.com.mind5.business.pet.model.checker.PetCheckExist;
import br.com.mind5.business.pet.model.checker.PetCheckLangu;
import br.com.mind5.business.pet.model.checker.PetCheckOwner;
import br.com.mind5.business.pet.model.checker.PetCheckPeteight;
import br.com.mind5.business.pet.model.checker.PetCheckPetype;
import br.com.mind5.business.pet.model.checker.PetCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PetRootUpdate extends DeciTreeTemplateWrite<PetInfo> {
	
	public PetRootUpdate(DeciTreeOption<PetInfo> option) {
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
		checker = new PetCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PetCheckBirthdate(checkerOption);
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
		checker = new PetCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PetCheckPetype(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PetCheckPeteight(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PetCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnPassedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();

		ActionStd<PetInfo> nodeSafe = new PetNodeSafe(option).toAction();
		ActionStd<PetInfo> nodeDefaultBefore = new PetNodeDefaultBeforeL1(option).toAction();
		ActionLazy<PetInfo> mergeToUpdate = new ActionLazyCommom<PetInfo>(option, PetVisiMergeToUpdate.class);
		ActionLazy<PetInfo> enforceLChanged = new ActionLazyCommom<PetInfo>(option, PetVisiEnforceLChanged.class);	
		ActionLazy<PetInfo> enforceLChangedBy = new ActionLazyCommom<PetInfo>(option, PetVisiMergeUsername.class);
		ActionLazy<PetInfo> update = new ActionLazyCommom<PetInfo>(option, PetVisiDaoUpdate.class);
		ActionLazy<PetInfo> nodeDefaultAfter = new ActionLazyCommom<PetInfo>(option, PetVisiNodeDefaultAfterL1.class);
		ActionLazy<PetInfo> snapshot = new ActionLazyCommom<PetInfo>(option, PetVisiNodeSnapshot.class);
		ActionLazy<PetInfo> select = new ActionLazyCommom<PetInfo>(option, PetVisiRootSelect.class);	
		
		nodeDefaultBefore.addPostAction(mergeToUpdate);
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(nodeDefaultAfter);
		nodeDefaultAfter.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(nodeSafe);
		actions.add(nodeDefaultBefore);
		
		return actions;
	}
}
