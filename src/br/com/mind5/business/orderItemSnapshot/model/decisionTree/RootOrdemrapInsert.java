package br.com.mind5.business.orderItemSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.action.LazyOrdemrapInsert;
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
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrdemrapInsert extends DeciTreeWriteTemplate<OrdemrapInfo> {
	
	public RootOrdemrapInsert(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemrapInfo> buildDecisionCheckerHook(DeciTreeOption<OrdemrapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdemrapInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemrapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdemrapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdemrapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdemrapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdemrapCheckOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemrapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStd<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemrapInfo> mergeMat = new StdOrdemrapMergeMat(option);
		ActionLazy<OrdemrapInfo> nodeStore = new LazyOrdemrapNodeStore(option.conn, option.schemaName);
		ActionLazy<OrdemrapInfo> nodeEmp = new LazyOrdemrapNodeEmp(option.conn, option.schemaName);
		ActionLazy<OrdemrapInfo> insert = new LazyOrdemrapInsert(option.conn, option.schemaName);
		
		mergeMat.addPostAction(nodeStore);
		nodeStore.addPostAction(nodeEmp);
		nodeEmp.addPostAction(insert);
		
		actions.add(mergeMat);
		return actions;
	}
}
