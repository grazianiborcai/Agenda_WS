package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceLChanged;
import br.com.gda.business.owner.model.action.LazyOwnerMergeUsername;
import br.com.gda.business.owner.model.action.LazyOwnerNodeSnapshot;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpdateComp;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpdatePerson;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertAddress;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertPhone;
import br.com.gda.business.owner.model.action.LazyOwnerRootSelect;
import br.com.gda.business.owner.model.action.StdOwnerMergeToUpdate;
import br.com.gda.business.owner.model.checker.OwnerCheckExist;
import br.com.gda.business.owner.model.checker.OwnerCheckUpdate;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOwnerUpdate extends DeciTreeWriteTemplate<OwnerInfo> {	
	
	public RootOwnerUpdate(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();

		ActionStd<OwnerInfo> mergeToUpdate = new StdOwnerMergeToUpdate(option);
		ActionLazy<OwnerInfo> enforceLChanged = new LazyOwnerEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> mergeUsername = new LazyOwnerMergeUsername(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> updatePerson = new LazyOwnerNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> updateCompany = new LazyOwnerNodeUpdateComp(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<OwnerInfo> snapshot = new LazyOwnerNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> select = new LazyOwnerRootSelect(option.conn, option.schemaName);		
		
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
