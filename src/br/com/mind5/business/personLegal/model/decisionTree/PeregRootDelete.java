package br.com.mind5.business.personLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.action.PeregVisiDaoDelete;
import br.com.mind5.business.personLegal.model.action.PeregVisiDaoUpdate;
import br.com.mind5.business.personLegal.model.action.PeregVisiEnforceLChanged;
import br.com.mind5.business.personLegal.model.action.PeregVisiMergeToDelete;
import br.com.mind5.business.personLegal.model.action.PeregVisiMergeUsername;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodeAddressDelete;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodePhoneDelete;
import br.com.mind5.business.personLegal.model.action.PeregVisiPersonDelete;
import br.com.mind5.business.personLegal.model.checker.PeregCheckDelete;
import br.com.mind5.business.personLegal.model.checker.PeregCheckExist;
import br.com.mind5.business.personLegal.model.checker.PeregCheckLangu;
import br.com.mind5.business.personLegal.model.checker.PeregCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PeregRootDelete extends DeciTreeTemplateWrite<PeregInfo> {
	
	public PeregRootDelete(DeciTreeOption<PeregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeregInfo> buildCheckerHook(DeciTreeOption<PeregInfo> option) {
		List<ModelChecker<PeregInfo>> queue = new ArrayList<>();		
		ModelChecker<PeregInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PeregCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new PeregCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new PeregCheckOwner(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new PeregCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerHelperQueue<PeregInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeregInfo>> buildActionsOnPassedHook(DeciTreeOption<PeregInfo> option) {
		List<ActionStd<PeregInfo>> actions = new ArrayList<>();
		
		ActionStd<PeregInfo> mergeToDelete = new ActionStdCommom<PeregInfo>(option, PeregVisiMergeToDelete.class);
		ActionLazy<PeregInfo> enforceLChanged = new ActionLazyCommom<PeregInfo>(option, PeregVisiEnforceLChanged.class);
		ActionLazy<PeregInfo> enforceLChangedBy = new ActionLazyCommom<PeregInfo>(option, PeregVisiMergeUsername.class);
		ActionLazy<PeregInfo> update = new ActionLazyCommom<PeregInfo>(option, PeregVisiDaoUpdate.class);
		ActionLazy<PeregInfo> deleteAddress = new ActionLazyCommom<PeregInfo>(option, PeregVisiNodeAddressDelete.class);
		ActionLazy<PeregInfo> deletePhone = new ActionLazyCommom<PeregInfo>(option, PeregVisiNodePhoneDelete.class);
		ActionLazy<PeregInfo> deletePerson = new ActionLazyCommom<PeregInfo>(option, PeregVisiPersonDelete.class);
		ActionLazy<PeregInfo> deletePereg = new ActionLazyCommom<PeregInfo>(option, PeregVisiDaoDelete.class);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);		
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deletePereg);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
