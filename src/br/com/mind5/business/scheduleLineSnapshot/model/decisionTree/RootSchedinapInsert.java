package br.com.mind5.business.scheduleLineSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapInsert;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergapStolis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergapUselis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergeCuslis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergeEmplis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergeMatlis;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckLangu;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckOwner;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckSchedine;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedinapInsert extends DeciTreeWriteTemplate<SchedinapInfo> {
	
	public RootSchedinapInsert(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedinapInfo> buildDecisionCheckerHook(DeciTreeOption<SchedinapInfo> option) {
		List<ModelChecker<SchedinapInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedinapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedinapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckSchedine(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedinapInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStdV1<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedinapInfo> nodeOrder = new NodeSchedinapOrder(option).toAction();
		ActionLazyV1<SchedinapInfo> mergeMatlis = new LazySchedinapMergeMatlis(option.conn, option.schemaName);
		ActionLazyV1<SchedinapInfo> mergeStolis = new LazySchedinapMergapStolis(option.conn, option.schemaName);
		ActionLazyV1<SchedinapInfo> mergCuslis = new LazySchedinapMergeCuslis(option.conn, option.schemaName);
		ActionLazyV1<SchedinapInfo> mergUselis = new LazySchedinapMergapUselis(option.conn, option.schemaName);
		ActionLazyV1<SchedinapInfo> mergeEmplis = new LazySchedinapMergeEmplis(option.conn, option.schemaName);
		ActionLazyV1<SchedinapInfo> insert = new LazySchedinapInsert(option.conn, option.schemaName);
		
		nodeOrder.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergCuslis);		
		mergCuslis.addPostAction(mergUselis);		
		mergUselis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(insert);
		
		actions.add(nodeOrder);
		return actions;
	}
}
