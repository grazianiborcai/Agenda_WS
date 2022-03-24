package br.com.mind5.business.orderItemSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.action.OrdemrapVisiNodeCus;
import br.com.mind5.business.orderItemSnapshot.model.action.OrdemrapVisiNodeEmp;
import br.com.mind5.business.orderItemSnapshot.model.action.OrdemrapVisiNodeStore;
import br.com.mind5.business.orderItemSnapshot.model.action.OrdemrapVisiDaoInsert;
import br.com.mind5.business.orderItemSnapshot.model.action.OrdemrapVisiMergeMat;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckLangu;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckOrderem;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckOwner;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrdemrapRootInsert extends DeciTreeTemplateWrite<OrdemrapInfo> {
	
	public OrdemrapRootInsert(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemrapInfo> buildCheckerHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ModelChecker<OrdemrapInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemrapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdemrapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdemrapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdemrapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdemrapCheckOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemrapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStd<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemrapInfo> mergeMat = new ActionStdCommom<OrdemrapInfo>(option, OrdemrapVisiMergeMat.class);
		ActionLazy<OrdemrapInfo> nodeStore = new ActionLazyCommom<OrdemrapInfo>(option, OrdemrapVisiNodeStore.class);
		ActionLazy<OrdemrapInfo> nodeEmp = new ActionLazyCommom<OrdemrapInfo>(option, OrdemrapVisiNodeEmp.class);
		ActionLazy<OrdemrapInfo> nodeCus = new ActionLazyCommom<OrdemrapInfo>(option, OrdemrapVisiNodeCus.class);
		ActionLazy<OrdemrapInfo> insert = new ActionLazyCommom<OrdemrapInfo>(option, OrdemrapVisiDaoInsert.class);
		
		mergeMat.addPostAction(nodeStore);
		nodeStore.addPostAction(nodeEmp);
		nodeEmp.addPostAction(nodeCus);
		nodeCus.addPostAction(insert);
		
		actions.add(mergeMat);
		return actions;
	}
}
