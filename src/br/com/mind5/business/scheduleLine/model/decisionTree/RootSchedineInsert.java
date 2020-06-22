package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineBookiceValidate;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeInsert;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineObfuscateOrder;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedineInsert extends DeciTreeTemplateWriteV2<SchedineInfo> {
	
	public RootSchedineInsert(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelCheckerV1<SchedineInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedineInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV1<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedineInfo> obfuscateOrder = new StdSchedineObfuscateOrder(option);
		ActionLazyV1<SchedineInfo> bookiceValidate = new LazySchedineBookiceValidate(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> nodeInsert = new LazySchedineNodeInsert(option.conn, option.schemaName);
		
		obfuscateOrder.addPostAction(bookiceValidate);
		bookiceValidate.addPostAction(nodeInsert);
		
		actions.add(obfuscateOrder);
		return actions;
	}
}
