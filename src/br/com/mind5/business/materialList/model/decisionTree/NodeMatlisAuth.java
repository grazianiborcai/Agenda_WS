package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.StdMatlisMergeSytotauh;
import br.com.mind5.business.materialList.model.action.StdMatlisSuccess;
import br.com.mind5.business.materialList.model.checker.MatlisCheckAuthCustomer;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeMatlisAuth extends DeciTreeTemplateReadV2<MatlisInfo> {
	
	public NodeMatlisAuth(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatlisInfo> buildCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelCheckerV1<MatlisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatlisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatlisCheckAuthCustomer(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStdV2<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatlisInfo> success = new StdMatlisSuccess(option);

		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<MatlisInfo>> buildActionsOnFailedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStdV2<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatlisInfo> mergeSytotauh = new StdMatlisMergeSytotauh(option);
		
		actions.add(mergeSytotauh);
		return actions;
	}
}
