package br.com.mind5.business.customerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.action.CusnapVisiNodeStore;
import br.com.mind5.business.customerSnapshot.model.action.CusnapVisiNodeUser;
import br.com.mind5.business.customerSnapshot.model.action.CusnapVisiDaoInsert;
import br.com.mind5.business.customerSnapshot.model.action.CusnapVisiMergePerson;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckLangu;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckOwner;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CusnapRootInsert extends DeciTreeTemplateWrite<CusnapInfo> {

	public CusnapRootInsert(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusnapInfo> buildCheckerHook(DeciTreeOption<CusnapInfo> option) {	
		List<ModelChecker<CusnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CusnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusnapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStd<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CusnapInfo> mergePerson = new ActionStdCommom<CusnapInfo>(option, CusnapVisiMergePerson.class);
		ActionLazy<CusnapInfo> nodeUser = new ActionLazyCommom<CusnapInfo>(option, CusnapVisiNodeUser.class);
		ActionLazy<CusnapInfo> nodeStore = new ActionLazyCommom<CusnapInfo>(option, CusnapVisiNodeStore.class);
		ActionLazy<CusnapInfo> insert = new ActionLazyCommom<CusnapInfo>(option, CusnapVisiDaoInsert.class);
		
		mergePerson.addPostAction(nodeUser);
		nodeUser.addPostAction(nodeStore);
		nodeStore.addPostAction(insert);
		
		actions.add(mergePerson);	
		return actions;
	}
}
