package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerDelete;
import br.com.mind5.business.owner.model.action.LazyOwnerDeleteComp;
import br.com.mind5.business.owner.model.action.LazyOwnerDeletePerson;
import br.com.mind5.business.owner.model.action.LazyOwnerDeleteUser;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceLChanged;
import br.com.mind5.business.owner.model.action.LazyOwnerMergeUsername;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeDeleteAddress;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeDeletePhone;
import br.com.mind5.business.owner.model.action.LazyOwnerUpdate;
import br.com.mind5.business.owner.model.action.StdOwnerMergeToDelete;
import br.com.mind5.business.owner.model.checker.OwnerCheckDelete;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOwnerDeleteCascade extends DeciTreeWriteTemplate<OwnerInfo> {

	public RootOwnerDeleteCascade(DeciTreeOption<OwnerInfo> option) {
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
		checker = new OwnerCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<OwnerInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerInfo> mergeToDelete = new StdOwnerMergeToDelete(option);
		ActionLazyV1<OwnerInfo> enforceLChanged = new LazyOwnerEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> enforceLChangedBy = new LazyOwnerMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> update = new LazyOwnerUpdate(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> deleteAddress = new LazyOwnerNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> deletePhone = new LazyOwnerNodeDeletePhone(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> deletePerson = new LazyOwnerDeletePerson(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> deleteCompany = new LazyOwnerDeleteComp(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> deleteUser = new LazyOwnerDeleteUser(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> deleteOwner = new LazyOwnerDelete(option.conn, option.schemaName);			
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deleteCompany);	
		update.addPostAction(deleteUser);
		update.addPostAction(deleteOwner);
		
		actions.add(mergeToDelete);
		
		return actions;
	}
}
