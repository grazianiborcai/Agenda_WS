package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposRootDelete;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceProfessional;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmposDeleteProfessional extends DeciTreeTemplateWriteV2<EmposInfo> {
	
	public RootEmposDeleteProfessional(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelCheckerV1<EmposInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmposInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV2<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmposInfo> enforceProfessional = new StdEmposEnforceProfessional(option);
		ActionLazy<EmposInfo> delete = new LazyEmposRootDelete(option.conn, option.schemaName);
		
		enforceProfessional.addPostAction(delete);
		
		actions.add(enforceProfessional);
		return actions;		
	}
}
