package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposRootSelect;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceProfessional;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEmposSelectProfessional extends DeciTreeTemplateReadV2<EmposInfo> {
	
	public RootEmposSelectProfessional(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelCheckerV1<EmposInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmposInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV2<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmposInfo> enforceProfessional	= new StdEmposEnforceProfessional(option);
		ActionLazy<EmposInfo> select = new LazyEmposRootSelect(option.conn, option.schemaName);
		
		enforceProfessional.addPostAction(select);
		
		actions.add(enforceProfessional);
		return actions;
	}
}
