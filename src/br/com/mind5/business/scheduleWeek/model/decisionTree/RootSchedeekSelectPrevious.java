package br.com.mind5.business.scheduleWeek.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekRootSelect;
import br.com.mind5.business.scheduleWeek.model.action.StdSchedeekMergePrevious;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedeekSelectPrevious extends DeciTreeTemplateWriteV2<SchedeekInfo> {
	
	public RootSchedeekSelectPrevious(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedeekInfo> buildCheckerHook(DeciTreeOption<SchedeekInfo> option) {
		List<ModelCheckerV1<SchedeekInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedeekInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedeekInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStdV1<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedeekInfo> mergePrevious = new StdSchedeekMergePrevious(option);
		ActionLazyV1<SchedeekInfo> select = new LazySchedeekRootSelect(option.conn, option.schemaName);
		
		mergePrevious.addPostAction(select);
		
		actions.add(mergePrevious);
		return actions;
	}
}
