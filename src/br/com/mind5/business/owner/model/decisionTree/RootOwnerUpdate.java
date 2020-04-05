package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceLChanged;
import br.com.mind5.business.owner.model.action.LazyOwnerMergeUsername;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeSnapshot;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeUpdateComp;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeUpdatePerson;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeUpsertAddress;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeUpsertPhone;
import br.com.mind5.business.owner.model.action.LazyOwnerRootSelect;
import br.com.mind5.business.owner.model.action.StdOwnerMergeToUpdate;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.business.owner.model.checker.OwnerCheckUpdate;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOwnerUpdate extends DeciTreeWriteTemplate<OwnerInfo> {	
	
	public RootOwnerUpdate(DeciTreeOption<OwnerInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();

		ActionStdV1<OwnerInfo> mergeToUpdate = new StdOwnerMergeToUpdate(option);
		ActionLazyV1<OwnerInfo> enforceLChanged = new LazyOwnerEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> mergeUsername = new LazyOwnerMergeUsername(option.conn, option.schemaName);	
		ActionLazyV1<OwnerInfo> updatePerson = new LazyOwnerNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> updateCompany = new LazyOwnerNodeUpdateComp(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazyV1<OwnerInfo> snapshot = new LazyOwnerNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> select = new LazyOwnerRootSelect(option.conn, option.schemaName);		
		
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
