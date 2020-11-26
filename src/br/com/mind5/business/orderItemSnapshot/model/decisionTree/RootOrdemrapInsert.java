package br.com.mind5.business.orderItemSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.action.LazyOrdemrapDaoInsert;
import br.com.mind5.business.orderItemSnapshot.model.action.LazyOrdemrapNodeCus;
import br.com.mind5.business.orderItemSnapshot.model.action.LazyOrdemrapNodeEmp;
import br.com.mind5.business.orderItemSnapshot.model.action.LazyOrdemrapNodeStore;
import br.com.mind5.business.orderItemSnapshot.model.action.StdOrdemrapMergeMat;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckLangu;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckOrderem;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckOwner;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootOrdemrapInsert extends DeciTreeTemplateWrite<OrdemrapInfo> {
	
	public RootOrdemrapInsert(DeciTreeOption<OrdemrapInfo> option) {
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
		
		ActionStd<OrdemrapInfo> mergeMat = new StdOrdemrapMergeMat(option);
		ActionLazy<OrdemrapInfo> nodeStore = new LazyOrdemrapNodeStore(option.conn, option.schemaName);
		ActionLazy<OrdemrapInfo> nodeEmp = new LazyOrdemrapNodeEmp(option.conn, option.schemaName);
		ActionLazy<OrdemrapInfo> nodeCus = new LazyOrdemrapNodeCus(option.conn, option.schemaName);
		ActionLazy<OrdemrapInfo> insert = new LazyOrdemrapDaoInsert(option.conn, option.schemaName);
		
		mergeMat.addPostAction(nodeStore);
		nodeStore.addPostAction(nodeEmp);
		nodeEmp.addPostAction(nodeCus);
		nodeCus.addPostAction(insert);
		
		actions.add(mergeMat);
		return actions;
	}
}
