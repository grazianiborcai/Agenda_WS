package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerDelete;
import br.com.gda.business.owner.model.action.LazyOwnerDeleteComp;
import br.com.gda.business.owner.model.action.LazyOwnerDeleteMat;
import br.com.gda.business.owner.model.action.LazyOwnerDeletePerson;
import br.com.gda.business.owner.model.action.LazyOwnerDeleteUser;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceLChanged;
import br.com.gda.business.owner.model.action.LazyOwnerMergeUsername;
import br.com.gda.business.owner.model.action.LazyOwnerNodeDeleteAddress;
import br.com.gda.business.owner.model.action.LazyOwnerNodeDeletePhone;
import br.com.gda.business.owner.model.action.LazyOwnerUpdate;
import br.com.gda.business.owner.model.action.StdOwnerMergeToDelete;
import br.com.gda.business.owner.model.checker.OwnerCheckDelete;
import br.com.gda.business.owner.model.checker.OwnerCheckExist;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

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
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> mergeToDelete = new StdOwnerMergeToDelete(option);
		ActionLazy<OwnerInfo> enforceLChanged = new LazyOwnerEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> enforceLChangedBy = new LazyOwnerMergeUsername(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> update = new LazyOwnerUpdate(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deleteAddress = new LazyOwnerNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deletePhone = new LazyOwnerNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deletePerson = new LazyOwnerDeletePerson(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deleteCompany = new LazyOwnerDeleteComp(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deleteMat = new LazyOwnerDeleteMat(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deleteUser = new LazyOwnerDeleteUser(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> deleteOwner = new LazyOwnerDelete(option.conn, option.schemaName);			
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deleteCompany);	
		update.addPostAction(deleteMat);
		update.addPostAction(deleteUser);
		update.addPostAction(deleteOwner);
		
		actions.add(mergeToDelete);
		
		return actions;
	}
}
