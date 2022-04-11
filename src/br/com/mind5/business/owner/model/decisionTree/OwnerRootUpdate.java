package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.OwnerVisiNodeSnapshot;
import br.com.mind5.business.owner.model.action.OwnerVisiNodeCompUpdate;
import br.com.mind5.business.owner.model.action.OwnerVisiNodePersonUpdate;
import br.com.mind5.business.owner.model.action.OwnerVisiNodeAddressUpsert;
import br.com.mind5.business.owner.model.action.OwnerVisiNodePhoneUpsert;
import br.com.mind5.business.owner.model.action.OwnerVisiRootSelect;
import br.com.mind5.business.owner.model.action.OwnerVisiEnforceLChanged;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeToUpdate;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeUsername;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.business.owner.model.checker.OwnerCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OwnerRootUpdate extends DeciTreeTemplateWrite<OwnerInfo> {	
	
	public OwnerRootUpdate(DeciTreeOption<OwnerInfo> option) {
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
		checker = new OwnerCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();

		ActionStd<OwnerInfo> mergeToUpdate = new ActionStdCommom<OwnerInfo>(option, OwnerVisiMergeToUpdate.class);
		ActionLazy<OwnerInfo> enforceLChanged = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiEnforceLChanged.class);
		ActionLazy<OwnerInfo> mergeUsername = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergeUsername.class);	
		ActionLazy<OwnerInfo> updatePerson = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodePersonUpdate.class);
		ActionLazy<OwnerInfo> updateCompany = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodeCompUpdate.class);
		ActionLazy<OwnerInfo> upsertAddress = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodeAddressUpsert.class);
		ActionLazy<OwnerInfo> upsertPhone = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodePhoneUpsert.class);		
		ActionLazy<OwnerInfo> snapshot = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodeSnapshot.class);
		ActionLazy<OwnerInfo> select = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiRootSelect.class);		
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUsername);
		
		mergeUsername.addPostAction(updatePerson);
		mergeUsername.addPostAction(updateCompany);		
		mergeUsername.addPostAction(upsertAddress);		
		mergeUsername.addPostAction(upsertPhone);
		mergeUsername.addPostAction(snapshot);
		mergeUsername.addPostAction(select);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
