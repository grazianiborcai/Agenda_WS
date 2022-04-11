package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.OwnerVisiDaoDelete;
import br.com.mind5.business.owner.model.action.OwnerVisiDaoUpdate;
import br.com.mind5.business.owner.model.action.OwnerVisiEnforceLChanged;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeToDelete;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeUsername;
import br.com.mind5.business.owner.model.checker.OwnerCheckDelete;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OwnerRootDelete extends DeciTreeTemplateWrite<OwnerInfo> {

	public OwnerRootDelete(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new OwnerCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerHelperQueue<OwnerInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> mergeToDelete = new ActionStdCommom<OwnerInfo>(option, OwnerVisiMergeToDelete.class);
		ActionLazy<OwnerInfo> enforceLChanged = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiEnforceLChanged.class);
		ActionLazy<OwnerInfo> enforceLChangedBy = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergeUsername.class);
		ActionLazy<OwnerInfo> update = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiDaoUpdate.class);
		ActionLazy<OwnerInfo> delete = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiDaoDelete.class);			
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		
		return actions;
	}
}
