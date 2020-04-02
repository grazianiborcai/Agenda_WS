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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdemrapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStdV1<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrdemrapInfo> mergeMat = new StdOrdemrapMergeMat(option);
		ActionLazyV1<OrdemrapInfo> nodeStore = new LazyOrdemrapNodeStore(option.conn, option.schemaName);
		ActionLazyV1<OrdemrapInfo> nodeEmp = new LazyOrdemrapNodeEmp(option.conn, option.schemaName);
		ActionLazyV1<OrdemrapInfo> insert = new LazyOrdemrapInsert(option.conn, option.schemaName);
		
		mergeMat.addPostAction(nodeStore);
		nodeStore.addPostAction(nodeEmp);
		nodeEmp.addPostAction(insert);
		
		actions.add(mergeMat);
		return actions;
	}
}
