package br.com.mind5.business.personLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodeAddressInsert;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodeInsert;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodePersonInsert;
import br.com.mind5.business.personLegal.model.action.PeregVisiNodePhoneInsert;
import br.com.mind5.business.personLegal.model.action.PeregVisiRootSelect;
import br.com.mind5.business.personLegal.model.checker.PeregCheckInsert;
import br.com.mind5.business.personLegal.model.checker.PeregCheckLangu;
import br.com.mind5.business.personLegal.model.checker.PeregCheckOwner;
import br.com.mind5.business.personLegal.model.checker.PeregCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PeregRootInsert extends DeciTreeTemplateWrite<PeregInfo> {

	public PeregRootInsert(DeciTreeOption<PeregInfo> option) {
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
		checker = new PeregCheckInsert(checkerOption);
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
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new PeregCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeregInfo>> buildActionsOnPassedHook(DeciTreeOption<PeregInfo> option) {
		List<ActionStd<PeregInfo>> actions = new ArrayList<>();
	
		ActionStd<PeregInfo> insertLegalPerson = new ActionStdCommom<PeregInfo>(option, PeregVisiNodeInsert.class);
		ActionLazy<PeregInfo> insertPerson = new ActionLazyCommom<PeregInfo>(option, PeregVisiNodePersonInsert.class);
		ActionLazy<PeregInfo> insertAddress = new ActionLazyCommom<PeregInfo>(option, PeregVisiNodeAddressInsert.class);
		ActionLazy<PeregInfo> insertPhone = new ActionLazyCommom<PeregInfo>(option, PeregVisiNodePhoneInsert.class);
		ActionLazy<PeregInfo> select = new ActionLazyCommom<PeregInfo>(option, PeregVisiRootSelect.class);	
		
		insertLegalPerson.addPostAction(insertPerson);
		insertPerson.addPostAction(insertAddress);
		insertAddress.addPostAction(insertPhone);
		insertPhone.addPostAction(select);
		
		actions.add(insertLegalPerson);	
		return actions;
	}
}
