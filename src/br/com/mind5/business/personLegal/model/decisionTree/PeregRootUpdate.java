package br.com.mind5.business.personLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.action.PeregVisiMergeToUpdate;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodeAddressUpdate;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodePersonUpdate;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodePhoneUpdate;
import br.com.mind5.business.personLegal.model.checker.PeregCheckExist;
import br.com.mind5.business.personLegal.model.checker.PeregCheckLangu;
import br.com.mind5.business.personLegal.model.checker.PeregCheckOwner;
import br.com.mind5.business.personLegal.model.checker.PeregCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PeregRootUpdate extends DeciTreeTemplateWrite<PeregInfo> {
	
	public PeregRootUpdate(DeciTreeOption<PeregInfo> option) {
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
		checker = new PeregCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new PeregCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new PeregCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new PeregCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeregInfo>> buildActionsOnPassedHook(DeciTreeOption<PeregInfo> option) {
		List<ActionStd<PeregInfo>> actions = new ArrayList<>();

		ActionStd<PeregInfo> mergeToUpdate = new ActionStdCommom<PeregInfo>(option, PeregVisiMergeToUpdate.class);	
		ActionLazy<PeregInfo> updatePerson = new ActionLazyCommom<PeregInfo>(option, PeregVisiNodePersonUpdate.class);	
		ActionLazy<PeregInfo> updateAddress = new ActionLazyCommom<PeregInfo>(option, PeregVisiNodeAddressUpdate.class);	
		ActionLazy<PeregInfo> updatePhone = new ActionLazyCommom<PeregInfo>(option, PeregVisiNodePhoneUpdate.class);		
		ActionStd<PeregInfo> select = new PeregRootSelect(option).toAction();	
		
		mergeToUpdate.addPostAction(updatePerson);
		updatePerson.addPostAction(updateAddress);
		updateAddress.addPostAction(updatePhone);
		
		actions.add(mergeToUpdate);
		actions.add(select);
		
		return actions;
	}
}
