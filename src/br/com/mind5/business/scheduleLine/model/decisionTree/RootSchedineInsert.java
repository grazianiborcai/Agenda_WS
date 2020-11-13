package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineBookiceValidate;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineRootInsertForce;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineObfuscateRef;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineObfuscateOrder;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedineInsert extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public RootSchedineInsert(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> obfuscateOrder = new StdSchedineObfuscateOrder(option);
		ActionLazy<SchedineInfo> obfuscateRef = new LazySchedineObfuscateRef(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> bookiceValidate = new LazySchedineBookiceValidate(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> insert = new LazySchedineRootInsertForce(option.conn, option.schemaName);
		
		obfuscateOrder.addPostAction(obfuscateRef);
		obfuscateRef.addPostAction(bookiceValidate);
		bookiceValidate.addPostAction(insert);
		
		actions.add(obfuscateOrder);
		return actions;
	}
}
